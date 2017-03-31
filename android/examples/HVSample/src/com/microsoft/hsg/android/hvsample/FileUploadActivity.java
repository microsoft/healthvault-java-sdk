package com.microsoft.hsg.android.hvsample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.RequestCallback;
import com.microsoft.hsg.android.simplexml.things.types.file.File;


public class FileUploadActivity extends Activity {
	
	HealthVaultApp service;
	HealthVaultClient hvClient;
	
	private Camera camera;
    private SurfaceView surfaceView;
    private View progressContainer;
    
    private Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {
        public void onShutter() {
            // display the progress indicator
        	progressContainer.setVisibility(View.VISIBLE);
        }
    };
    
    private Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
        	
            String filename = UUID.randomUUID().toString() + ".jpg";

            FileOutputStream os = null;
            boolean success = true;
            try {
                os = openFileOutput(filename, Context.MODE_PRIVATE);
                os.write(data);
            } catch (Exception e) {
                Log.e("FileUpload", "Error writing to file " + filename, e);
            } finally {
                try {
                    if (os != null)
                        os.close();
                } catch (Exception e) {
                    Log.e("FileUpload", "Error closing file " + filename, e);
                    success = false;
                } 
            }
            
            if (success) {
            	com.microsoft.hsg.android.simplexml.things.types.file.File hvFile = new com.microsoft.hsg.android.simplexml.things.types.file.File();
				hvFile.setName(filename);
				
				FileInputStream source;
				try {
					source = openFileInput(filename);
					hvClient.asyncRequest(hvFile.uploadAsync(HealthVaultApp.getInstance().getCurrentRecord(), null, source), 
	        				new FileUploadActivityCallback<Void>());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fileupload);
		
		service = HealthVaultApp.getInstance(this);
		hvClient = new HealthVaultClient();
		
		progressContainer = findViewById(R.id.camera_progressContainer);
        progressContainer.setVisibility(View.INVISIBLE);
        
        surfaceView = (SurfaceView)findViewById(R.id.camera_surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        
        holder.addCallback(new SurfaceHolder.Callback() {

            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (camera != null) {
                        camera.setPreviewDisplay(holder);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            public void surfaceDestroyed(SurfaceHolder holder) {
                if (camera != null) {
                    camera.stopPreview();
                }
            }

            public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            	if (camera == null) return;
            	
                Camera.Parameters parameters = camera.getParameters();
                Size s = getBestSupportedSize(parameters.getSupportedPreviewSizes(), w, h);
                parameters.setPreviewSize(s.width, s.height);
                s = getBestSupportedSize(parameters.getSupportedPictureSizes(), w, h);
                parameters.setPictureSize(s.width, s.height);
                camera.setParameters(parameters);
                try {
                    camera.startPreview();
                } catch (Exception e) {
                    camera.release();
                    camera = null;
                }
            }
        });
	
		// write buttons
		wireButtons();
	}
	
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		hvClient.start();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		hvClient.start();
	}



	@Override
    public void onResume() {
        super.onResume();
        camera = Camera.open();
    }

    @Override
    public void onPause() {
        super.onPause();

        if (camera != null) {
            camera.release();
            camera = null;
        }
    }
	
	private void wireButtons() {
		Button fileUploadBtn = (Button) findViewById(R.id.defaultFileupload);
		fileUploadBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("unchecked")
			public void onClick(View view) {
            	if (service.isAppConnected()) {
            		String filename = writeFile();
            		
            		InputStream source;
					try {
						source = openFileInput(filename);
						
						File hvFile = new File();
						hvFile.setName(filename);
						
						hvClient.start();
	            		
	            		hvClient.asyncRequest(hvFile.uploadAsync(HealthVaultApp.getInstance().getCurrentRecord(), null, source), 
	            				new FileUploadActivityCallback<Void>());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
        });
		
		Button cameraClickButton = (Button)findViewById(R.id.camera_click);
        cameraClickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (camera != null) {
            	    camera.takePicture(shutterCallback, null, jpegCallback);
            	}
            }
        });
	}
	
	private String writeFile() {
		String filename = "writefile" + (int)(Math.random() * 100)  + ".txt";
		String string = "This is from file upload";
		FileOutputStream outputStream;

		try {
		  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
		  outputStream.write(string.getBytes());
		  outputStream.close();
		  
		  return filename;
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		return null;
	}
	
	private class FileUploadActivityCallback<Void> implements RequestCallback {

		@Override
		public void onError(HVException exception) {
			// TODO Auto-generated method stub
			Toast.makeText(FileUploadActivity.this, exception.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onSuccess(Object t) {
			progressContainer.setVisibility(View.INVISIBLE);
			finish();
		}
	}
	
	private Size getBestSupportedSize(List<Size> sizes, int width, int height) {
        Size bestSize = sizes.get(0);
        int largestArea = bestSize.width * bestSize.height;
        for (Size s : sizes) {
            int area = s.width * s.height;
            if (area > largestArea) {
                bestSize = s;
                largestArea = area;
            }
        }
        return bestSize;
    }
}
