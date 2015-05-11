package inet.util.my;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Md5Util {
	// Tinh ma bam cho data va tra ve base64 - mĂ£ hĂ³a MD5
	public static String hash(String messages) throws Exception {
		if (messages == null){
			throw new NullPointerException();
		}
			
		StringBuffer result = null;
		byte[] data = messages.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(data);
			byte[] msgDigest = md.digest();
			result = new StringBuffer();
			for (int i = 0; i < msgDigest.length; i++) {
				String hex = Integer.toHexString(0xff & msgDigest[i]);
				if (hex.length() == 1){
					result.append('0');
				}
				result.append(hex);
			}
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.toString());
		}
		return result.toString();
	}
}
