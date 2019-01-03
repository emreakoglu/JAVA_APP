package put_get;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.pcf.CMQC;
import com.sun.org.apache.bcel.internal.util.ClassSet;

import sun.java2d.loops.DrawParallelogram;

public class Put_Get {
	
	MQQueueManager queueManager;

	
	public MQQueueManager getQueueManager() {
		return queueManager;
	}

	public void setQueueManager(MQQueueManager queueManager) {
		this.queueManager = queueManager;
	}

	public static void main(String args[]) throws MQException {
			
		File file = new File("C:\\Users\\emreAkoglu\\Desktop\\Cover_Letter.txt");
		
		Put_Get put_Get = new Put_Get();
		put_Get.setEnvironment("LOCAL_QM");
		
		//put_Get.putMessage("Merhaba Dunya", "DPLOG");
		put_Get.putMessage(file, "DPLOG");
		Object receivingMessage=put_Get.getMessage("DPLOG");
		
		//File file2 = (File) receivingMessage;
		
		System.out.println((String)receivingMessage);
		
	}
	
	public MQQueue getQueue(String qname) throws MQException {
		int openOptionsArg = CMQC.MQOO_INQUIRE | CMQC.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
		
		MQQueue mqQueue = getQueueManager().accessQueue(qname, openOptionsArg);
		
		return mqQueue;
		
	}
	
	public static boolean disconnect(MQQueue mqQueue, MQQueueManager mqQueueManager) {
		try {
			mqQueue.close();
			mqQueueManager.disconnect();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public void setEnvironment(String qmanagerName) throws MQException {

		MQEnvironment.hostname = "localhost"; // MQ Server Host or IP
		MQEnvironment.port = 1414;			  // MQ Listener Port
		MQEnvironment.channel = "DP.CHANNEL";	// MQ Channel 
		MQEnvironment.properties.put(CMQC.USER_ID_PROPERTY, "MUSR_MQADMIN"); // mq User for linux mqm
		MQEnvironment.properties.put(CMQC.PASSWORD_PROPERTY, "Passw0rd");		// mqm user Password
		MQEnvironment.properties.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES);
		
		MQQueueManager qmanager;
		qmanager = new MQQueueManager(qmanagerName); // Queue Manager name
		
		setQueueManager(qmanager);
		
	}
	
	public void putMessage(Object object,String qname) {
		MQMessage putMessage = new MQMessage();
		//putMessage.writeUTF("Merhaba Dunya MQ Put Testing"); // Put message content
		try {
			MQQueue DPLOG = getQueue(qname);
//			putMessage.writeUTF(object);
//			putMessage.writeObject(object);
			if(object.getClass().equals(File.class)) {
				// file içeriðini al
				BufferedReader reader = new BufferedReader(new FileReader((File)object));
				StringBuilder stringBuilder = new StringBuilder();
				char[] buffer = new char[10];
				while (reader.read(buffer) != -1) {
					stringBuilder.append(new String(buffer));
					buffer = new char[10];
				}
				reader.close();

				String content = stringBuilder.toString();
				putMessage.writeString(content);
			}
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			DPLOG.put(putMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Object getMessage(String qname) {
		MQGetMessageOptions gmo = new MQGetMessageOptions();
		MQMessage getMessage = new MQMessage();
		MQQueue DPLOG;
		byte[] strData = null;
		File filetemp = null;
		try {
			DPLOG = getQueue(qname);
			DPLOG.get(getMessage,gmo);
			int strLen = getMessage.getMessageLength();
			strData = new byte[strLen];
			getMessage.readFully(strData);
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = new String(strData);
		
//		File file = new File("C:\\Users\\emreAkoglu\\Desktop\\temp_file.txt");
//		FileOutputStream fos;
//		try {
//			fos = new FileOutputStream(file);
//			fos.write(strData);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		return message;
		
	}
}
