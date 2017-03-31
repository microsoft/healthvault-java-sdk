package com.microsoft.hsg.thing.oxm.jaxb.thing;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

public class TypeManager {
	
	private static final String PACKAGE_PREFIX =
    	"com.microsoft.hsg.thing.oxm.jaxb.";
	
	private static String[][] types = {
			{"227F55FB-1001-4D4E-9F6A-8D893E07B451", "hba1x.HbA1C"},
			{"7b2ea78c-4b78-4f75-a6a7-5396fe38b09a", "aerobicprofile.AerobicProfile"},
			{"e4501363-fb95-4a11-bb60-da64e98048b5", "aerobicweekly.AerobicWeekly"},
			{"90dbf000-fc55-4b92-b4a1-da45c36ad8bb", "aerobic.Aerobic"},
			{"d65ad514-c492-4b59-bd05-f3f6cb43ceb3", "allergicepisode.AllergicEpisode"},
			{"52bf9104-2c5e-4f1f-a66d-552ebcc53df7", "allergy.Allergy"},
			{"7AB3E662-CC5B-4BE2-BF38-78F8AAD5B161", "annotation.Annotation"},
			{"9ad2a94f-c6a4-4d78-8b50-75b65be0e250", "applicationdatareference.ApplicationDataReference"},
			{"a5033c9d-08cf-4204-9bd3-cb412ce39fc0", "application.AppSpecific"},
			{"4B18AEB6-5F01-444C-8C70-DBF13A2F510B", "appointment.Appointment"},
			{"03efe378-976a-42f8-ae1e-507c497a8c6d", "asthmainhaleruse.AsthmaInhalerUse"},
			{"ff9ce191-2096-47d8-9300-5469a9883746", "asthmainhaler.AsthmaInhaler"},
			{"bf516a61-5252-4c28-a979-27f45f62f78d", "basic.Basic"},
			{"3b3e6b16-eb69-483c-8d7e-dfe116ae6092", "basicV2.Basic"},
			{"879e7c04-4e8a-4707-9ad3-b054df467ce4", "bloodglucose.BloodGlucose"},
			{"3a54f95f-03d8-4f62-815f-f691fc94a500", "bloodoxygensaturation.BloodOxygenSaturation"},
			{"2fa3d1c1-db8c-4c0d-9873-fb01f0659360", "bluebuttontextfile.BlueButtonTextFile"},
			{"18adc276-5144-4e7e-bf6c-e56d8250adf8", "bodycomposition.BodyComposition"},
			{"dd710b31-2b6f-45bd-9552-253562b9a7c1", "bodydimension.BodyDimension"},
			{"ca3c57f4-f4c1-4e15-be67-0a3caf5414ed", "bp.BloodPressure"},
			{"d3170d30-a41b-4bde-a116-87698c8a001a", "calorieguideline.CalorieGuideline"},
			{"adaf49ad-8e10-49f8-9783-174819e97051", "cardiacprofile.CardiacProfile"},
			{"415c95e0-0533-4d9c-ac73-91dc5031186c", "careplan.CarePlan"},
			{"9c48a2b8-952c-4f5a-935d-f3292326bf54", "ccd"},
			{"1e1ccbfc-a55d-4d91-8940-fa2fbf73c195", "ccr.ContinuityOfCareRecord"},
			{"1ed1cba6-9530-44a3-b7b5-e8219690ebcf", "cda"},
			{"796C186F-B874-471c-8468-3EEFF73BF66E", "cholesterolprofile.CholesterolProfile"},
			{"98f76958-e34f-459b-a760-83c1699add38", "cholesterolprofile2.CholestorlProfile"},
			{"9f4e0fcd-10d7-416d-855a-90514ce2016b", "comment.Comment"},
			{"aea2e8f2-11dd-4a7d-ab43-1d58764ebc19", "concern.Concern"},
			{"7ea7a1f9-880b-4bd4-b593-f5660f20eda8", "condition.Condition"},
			{"162dd12d-9859-4a66-b75f-96760d67072b", "contact.Contact"},
			{"046d0ad7-6d7f-4bfd-afd4-4192ca2e913d", "contraindication.Contraindication"},
			{"A9A76456-0357-493e-B840-598BBB9483FD", "dailymedicationusage.DailyMediactionUsage"},
			{"EF9CF8D5-6C0B-4292-997F-4047240BC7BE", "device.Device"},
			{"80CF4080-AD3F-4BB5-A0B5-907C22F73017", "diabeticprofile.DiabeticProfile"},
			{"9c29c6b9-f40e-44ff-b24e-fba6f3074638", "dietaryintakedaily.DietaryIntakeDaily"},
			{"822a5e5a-14f1-4d06-b92f-8f3f1b05218f", "directive.Directive"},
			{"02EF57A2-A620-425A-8E92-A301542CCA54", "dischargesummary.DischargeSummary"},
			{"4b7971d6-e427-427d-bf2c-2fbcf76606b3", "emotion.Emotion"},
			{"3D4BDF01-1B3E-4AFC-B41C-BD3E641A6DA7", "encounter.Encounter"},
			{"e1f92d7f-9699-4483-8223-8442874ec6d9", "exercisesamples.ExerciseSamples"},
			{"85a21ddb-db20-4c65-8d30-33c899ccf612", "exercise.Exercise"},
			{"356fbba9-e0c9-4f4f-b0d9-4594f2490d2f", "explanationofbenefits.ExplanationOfBenefits"},
			{"6705549b-0e3d-474e-bfa7-8197ddd6786a", "familyhistorycondition"},
			{"cc23422c-4fba-4a23-b52a-c01d6cd53fdf", "familyhistoryperson.FamilyHistoryPerson"},
			{"22826e13-41e1-4ba3-8447-37dadd208fd8", "familyhistory.FamilyHistory"},
			{"6D39F894-F7AC-4FCE-AC78-B22693BF96E6", "familyhistory1.FamilyHistory"},
			{"4a04fcc8-19c1-4d59-a8c7-2031a03f21de", "familyhistory3.FamilyHistory"},
			{"bd0403c5-4ae2-4b0e-a8db-1888678e4528", "file.File"},
			{"9d006053-116c-43cc-9554-e0cda43558cb", "geneticsnpresults.GeneticSnpResults"},
			{"e75fa095-31ed-4b30-b5f7-463963b5e734", "groupmembershipactivity.GroupMembershipActivity"},
			{"66ac44c7-1d60-4e95-bb5b-d21490e91057", "groupmembership.GroupMembership"},
			{"58fd8ac4-6c47-41a3-94b2-478401f0e26c", "healthassessment.HealthAssessment"},
			{"7EA47715-CBA4-47F0-99D2-EB0A9FB4A85C", "healthcareproxy.HealthcareProxy"},
			{"1572af76-1653-4c39-9683-9f9ca6584ba3", "healthevent.HealthEvent"},
			{"dad8bb47-9ad0-4f09-a020-0ff051d1d0f7", "healthgoal.HealthGoal"},
			{"21d75546-8717-4deb-8b17-a57f48917790", "healthjournalentry.HealthJournalEntry"},
			{"b81eb4a6-6eac-4292-ae93-3872d6870994", "heartrate.HeartRate"},
			{"40750a6a-89b2-455c-bd8d-b420a4cb500b", "height.Height"},
			{"cd3587b5-b6e1-4565-ab3b-1c3ad45eb04f", "immunization.Immunization"},
			{"3d817dbe-af42-4a9d-a553-d1298b4d08fc", "immunization1.Immunization"},
			{"184166BE-8ADB-4D9C-8162-C403040E31AD", "insulininjectionuse.InsulinInjectionUse"},
			{"3B3C053B-B1FE-4E11-9E22-D4B480DE74E8", "insulininjection.InsulinInjection"},
			{"5800eab5-a8c2-482a-a4d6-f1db25ae08c3", "labtestresults.LabTestResults"},
			{"f57746af-9631-49dc-944e-2c92bee0d1e9", "labtestresults1.LabTestResults"},
			{"609319bf-35cc-40a4-b9d7-1b329679baaa", "lifegoal.LifeGoal"},
			{"d4b48e6b-50fa-4ba8-ac73-7d64a68dc328", "link.Link"},
			{"074e122a-335a-4a47-a63d-00a8f3e79e60", "mealdefinition.MealDefinition"},
			{"c75651c8-548e-449f-8942-9e6379b0b88a", "medicalimagestudy.MedicalImageStudy"},
			{"cdfc0a9b-6d3b-4d16-afa8-02b86d621a8d", "medicalimagestudy2.MedialImageStudy"},
			{"167ecf6b-bb54-43f9-a473-507b334907e0", "medicationfill.MedicationFill"},
			{"30cafccc-047d-4288-94ef-643571f7919d", "medication.Medication"},
			{"5C5F1223-F63C-4464-870C-3E36BA471DEF", "medication1.Medication"},
			{"72dc49e1-1486-4634-b651-ef560ed051e5", "message.Message"},
			{"B8FCB138-F8E6-436A-A15D-E3A2D6916094", "microbiologylabresults.MicrobiologyLabResults"},
			{"9085CAD9-E866-4564-8A91-7AD8685D204D", "papsession.PapSession"},
			{"9366440c-ec81-4b89-b231-308a4c4d70ed", "payer.Payer"},
			{"5d8419af-90f0-4875-a370-0f881c18f6b3", "peakflow.PeakFlow"},
			{"25c94a9f-9d3d-4576-96dc-6791178a8143", "base.Person"},
			{"a5294488-f865-4ce3-92fa-187cd3b58930", "personalimage.PersonalImage"},
			{"92ba621e-66b3-4a01-bd73-74844aed4f5b", "personal.Personal"},
			{"46d485cf-2b84-429d-9159-83152ba801f4", "pregnancy.Pregnancy"},
			{"5E2C027E-3417-4CFC-BD10-5A6F2E91AD23", "problem.Problem"},
			{"df4db479-a1ba-42a2-8714-2b083b88150f", "procedure.Procedure"},
			{"0A5F9A43-DC88-4E9F-890F-1F9159B76E7B", "procedure1.Procedure"},
			{"55d33791-58de-4cae-8c78-819e12ba5059", "questionanswer.QuestionAnswer"},
			{"E4911BD3-61BF-4E10-AE78-9C574B888B8F", "radiologylabresults.RadiologyLabResults"},
			{"5fd15cb7-b717-4b1c-89e0-1dbcf7f815dd", "respiratoryprofile.RespiratoryProfile"},
			{"11C52484-7F1A-11DB-AEAC-87D355D89593", "sleepjournalam.SleepAm"},
			{"031F5706-7F1A-11DB-AD56-7BD355D89593", "sleepjournalpm.SleepPm"},
			{"921588d1-27bf-423c-8e55-650d2fedb3e0", "spirometer.Spirometer"},
			{"d33a32b2-00de-43b8-9f2a-c4c7e9f580ec", "status.Status"},
			{"73822612-C15F-4B49-9E65-6AF369E55C65", "vitalsigns.VitalSigns"},
			{"b7925180-d69e-48fa-ae1d-cb3748ca170e", "weightgoal.WeightGoal"},
			{"3d34d87e-7fc1-4153-800f-f56592cb0d17", "weight.Weight"}
	};
	
	private static Map<String, Class> typeToClassMap = new HashMap<String, Class>();
	private static Map<Class, String> classToTypeMap = new HashMap<Class, String>();
	static {
		for(int i=0; i<types.length; i++)
		{
			String type = types[i][0].toLowerCase();
			String className = types[i][1];
			try {
				Class clazz = Class.forName(
				    PACKAGE_PREFIX + className);
				typeToClassMap.put(type, clazz);
				classToTypeMap.put(clazz, type);
			} catch (ClassNotFoundException e) {
			}
		}
	}
	
	public static String getTypeForClass(Class clazz)
	{
		return classToTypeMap.get(clazz);
	}
	
	public static Class getClassForType(String type)
	{
		
		return typeToClassMap.get(type);
	}

}
