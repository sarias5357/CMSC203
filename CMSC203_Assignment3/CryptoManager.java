/**
 * This class provides information to use either the 
 * bellaso cipher or caesar cipher to encrypt/decrypt a message using
 * ASCII characters from 32 to 95 ([SPACE, _])
 * @author Steven Arias
 *
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// Iterate through each character
		for (int i = 0; i < plainText.length(); i++) {
			// If the character is out of bounds, return false
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				return false;
		}
		// Else return true
		return true;
	}

	/** Steven Arias
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// Convert plainText to uppercase and create an empty string
		plainText = plainText.toUpperCase();
		String str = "";
		
		// Check if string is in bounds
		if (stringInBounds(plainText)) {
			/** Encryption for ASCII [SPACE, _]:
			 * P.i = ith character of plainText
			 * E = encrypted text
			 * E = ((P.i + key - 65) % 59) + 65
			 */
			// Iterate through each character
			for (int i = 0; i < plainText.length(); i++) {
				// Append char to string
				str += (char)(((int)plainText.charAt(i) + key - 65) % 59 + 65);
			}
		}
		
		// Return encrypted text
		return str;
	}
	
	/** Steven Arias
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// Convert plainText to uppercase and create an empty string
		plainText = plainText.toUpperCase();
		String str = "";
		
		// Generate key and convert to uppercase
		String key = getBellasoKey(plainText, bellasoStr);
		key = key.toUpperCase();
		
		/** Encryption for ASCII [SPACE, _]:
		 * P.i = ith character of plainText
		 * K.i = ith character of key
		 * E = encrypted text
		 * E = ((P.i + K.i - 32) % 64) + 32
		 */
		// Iterate through each character
		for (int i = 0; i < plainText.length(); ++i) {
			int n = (((plainText.charAt(i)) + (key.charAt(i) - 32)) % RANGE) + 32;
			
			// Convert ASCII to char and append to the string
			str += (char)(n); 
		}
		
		// Return encrypted text
		return str;
	}
	
	/** Steven Arias
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// Convert encrypted text to uppercase and create an empty string
		encryptedText = encryptedText.toUpperCase();
		String str = "";
		
		/**
		 * Decryption for ASCII [SPACE, _]:
		 * E.i = ith character of encrypted text
		 * O = original text
		 * O = (E.i - key - 65) % 59 + 65
		 */
		if (stringInBounds(encryptedText)) {
			for (int i = 0; i < encryptedText.length(); i++) {
				str += (char)(((int)encryptedText.charAt(i) - key - 65) % 59 + 65);
			}
		}
		
		// Return original text
		return str;
	}
	
	/** Steven Arias
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// Convert encrypted text to uppercase and create an empty string
		encryptedText = encryptedText.toUpperCase();
		String str = "";
		
		// Generate key and convert to uppercase
		String key = getBellasoKey(encryptedText, bellasoStr);
		key = key.toUpperCase();
		
		/**
		 * Decryption for ASCII [SPACE, _]:
		 * E.i = ith character of encrypted text
		 * K.i = ith character of key
		 * O = original text
		 * O = (E.i - K.i - 32) % 64 + 32
		 */
		for (int i = 0; i < encryptedText.length(); i++) {
			int n = (((encryptedText.charAt(i)) - (key.charAt(i) - 32)) % RANGE) + 32;
			
			/**
			 * Reset-error: invalid character needs to be added another 64 to make valid (reset)
			 * E.i = ith character of encrypted text
			 * K.i = ith character of the key
			 * O = original text
			 * O = (E.i - K.i - 32) % 64 + (32+64)
			 */
			if (n < LOWER_BOUND || n > UPPER_BOUND) {
				n = (((encryptedText.charAt(i)) - (key.charAt(i) - 32)) % RANGE) + (32 + RANGE);
			}
			
			// Convert to char and append
			str += (char)(n);
		}
		
		// Return original text
		return str;
	}
	
	/** Steven Arias
	 * Generates bellaso key by repeating string until length is matched
	 * @param text Desired key
	 * @param bellasoStr New, formatted key
	 * @return
	 */
	public static String getBellasoKey(String text, String bellasoStr) {
		// Store key length
		int textLen = text.length();
		
		// Iterate until length is matched
		for (int i = 0; ; i++) {
			// If the length has caught up to i, reset i
			if (textLen == i)
				i = 0;
			// If the lengths match, break
			if (bellasoStr.length() == text.length())
				break;
			// Append the character at the ith position to the end of the key
			bellasoStr += (bellasoStr.charAt(i));
		}
		
		// Return formatted key
		return bellasoStr;
	}
}
