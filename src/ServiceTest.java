
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ServiceTest {
	private static final String SOAP_ACTION1 = "http://tempuri.org/HelloWorld"; //Web Services命名空間+函數名稱
    private static final String HelloWorldmethod = "HelloWorld";//要呼叫的函數名稱
    private static final String NAMESPACE = "http://tempuri.org/"; //Web Services命名空間
    private static final String URL = "http://localhost:10106/MyServiceTest.asmx"; //Web Services的網址
	private static String x;
	
    public void CallSoap(){

    } 
        
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	x = CallHellow();
		System.out.print(x);
				
	}
    //使用KSOAP2,可至下列網址download
    //use KSOAP2,can go to this URL to download *.jar
    //https://code.google.com/archive/p/ksoap2-android/downloads
    public static String CallHellow()

    {
        String Get_HelloWorld="";
        try{
            // add paramaters and values
            SoapObject request1 = new SoapObject(NAMESPACE, HelloWorldmethod);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request1);
            //Web method call
            HttpTransportSE HttpTransport = new HttpTransportSE(URL);
            HttpTransport.debug = true;
            HttpTransport.call(SOAP_ACTION1, envelope);
            //get the response
            SoapPrimitive result= (SoapPrimitive)envelope.getResponse();
            String results = result.toString();
            Get_HelloWorld=results;
        }catch (Exception e){
             Get_HelloWorld=e.getMessage(); //將錯誤訊息傳回
        }
        return Get_HelloWorld; //傳回字串
    }
}
    
