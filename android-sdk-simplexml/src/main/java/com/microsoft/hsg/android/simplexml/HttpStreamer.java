package com.microsoft.hsg.android.simplexml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import android.net.Uri;

import com.microsoft.hsg.ResponseHandler;
import com.microsoft.hsg.Transport;

public class HttpStreamer implements Transport {

	public static final String OctetStreamMimeType = "application/octet-stream";

	public HttpStreamer() {

	}

	@Override
	public void doRequest(String arg0, ResponseHandler arg1) {
		// TODO Auto-generated method stub
	}

	// doesn't close destination stream 
	public void download(String uri, OutputStream destination)
			throws URISyntaxException, IOException {

		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput (true);
		conn.setConnectTimeout(0);
		conn.setReadTimeout(0);
		conn.setRequestMethod("GET");

		conn.connect();
		InputStream input = conn.getInputStream();
		try{
			copy(input, destination);
		} finally {
			input.close();
		}
	}

	// doesn't close input stream
	public int upload(String uri,
			InputStream from,
			int chunkSize,
			int maxSize) throws IOException { 

		byte[] buf = new byte[chunkSize];
		byte[] peakBuf = new byte[1];

		int currentChunkSize = 0;
		long total = 0;
		long countUploaded = 0;

		boolean usePeakBuffer = false;

		while (true) {

			if(usePeakBuffer) {
				buf[0] = peakBuf[0];
				total += 1;
				currentChunkSize += 1;
				usePeakBuffer = false;
			}

			int r = from.read(buf, (int)currentChunkSize, (int)(chunkSize - currentChunkSize));

			if(r != -1) {
				total += r;
				currentChunkSize += r;
			}

			if(currentChunkSize == 0) {
				break;
			}

			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput (true);
			conn.setDoOutput (true);
			conn.setConnectTimeout(0);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-type", OctetStreamMimeType);

			if(currentChunkSize == chunkSize) {
				if(r != -1) {
					// peak
					int peak = from.read(peakBuf);

					if(peak == -1) {
						conn.addRequestProperty("x-hv-blob-complete", "1");
					}
					else {
						usePeakBuffer = true;
					}
				}
			}
			else {
				conn.addRequestProperty("x-hv-blob-complete", "1");
			}

			conn.setRequestProperty("content-range",
					String.format("bytes %d-%d/*", 
							countUploaded, countUploaded + currentChunkSize - 1 ));

			OutputStream to = conn.getOutputStream();

			to.write(buf, 0, currentChunkSize);
			to.close();

			InputStream is = conn.getInputStream();
			is.close();

			countUploaded += currentChunkSize;
			currentChunkSize = 0;
		}

		return (int)total;
	}

	private long copy(InputStream from, OutputStream to) throws IOException {
		byte[] buf = new byte[4096];
		long total = 0;
		while (true) {
			int r = from.read(buf);
			if (r == -1) {
				break;
			}
			to.write(buf, 0, r);
			total += r;
		}
		return total;
	}
}
