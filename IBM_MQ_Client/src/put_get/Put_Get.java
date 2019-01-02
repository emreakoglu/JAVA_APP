package put_get;

import java.io.IOException;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.pcf.CMQC;

public class Put_Get {

	
	public static void main(String args[]) {
		int openOptions = CMQC.MQOO_INQUIRE | CMQC.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
		MQEnvironment.hostname = "localhost"; // MQ Server Host or IP
		MQEnvironment.port = 1414;			  // MQ Listener Port
		MQEnvironment.channel = "DP.CHANNEL";	// MQ Channel 
		MQEnvironment.properties.put(CMQC.USER_ID_PROPERTY, "MUSR_MQADMIN"); // mq User for linux mqm
		MQEnvironment.properties.put(CMQC.PASSWORD_PROPERTY, "*****");		// mqm user Password
		MQEnvironment.properties.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES);
		
		MQQueueManager qmanager;
		try {
			qmanager = new MQQueueManager("LOCAL_QM"); // Queue Manager name
			MQQueue DPLOG = qmanager.accessQueue("DPLOG", openOptions); // Queue Name
			MQMessage putMessage = new MQMessage();
			putMessage.writeUTF("Merhaba Dunya MQ Put Testing"); // Put message content
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			DPLOG.put(putMessage);
			
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			MQMessage getMessage = new MQMessage();
			DPLOG.get(getMessage,gmo);
	
			int strLen = getMessage.getMessageLength();
			byte[] strData = new byte[strLen];
			getMessage.readFully(strData,0,strLen);
			String message = new String(strData);
			
			System.out.println(message);
			DPLOG.close();
			qmanager.disconnect();
		} catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
