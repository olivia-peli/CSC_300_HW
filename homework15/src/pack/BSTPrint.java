package pack;

public class BSTPrint {
	public static String treeToString(Node subtreeRoot) {
	      if (subtreeRoot == null) {
	         return "(empty tree)";
	      }
	      
	      String[] lines = treeToLines(subtreeRoot);

	      String treeString = lines[0];
	      for (int i = 1; i < lines.length; i++) {
	         treeString += ("\n" + lines[i]);
	      }
	      return treeString;
	   }
	 private static String[] treeToLines(Node subtreeRoot) {
	      if (subtreeRoot == null) {
	         return new String[0];
	      }

	      String rootString = "[" + subtreeRoot.key + "]";
	      int rootStrLen = rootString.length();

	      if (subtreeRoot.left == null && subtreeRoot.right == null) {
	         String[] oneLine = new String[1];
	         oneLine[0] = rootString;
	         return oneLine;
	      }

	      String[] leftLines = treeToLines(subtreeRoot.left);
	      String[] rightLines = treeToLines(subtreeRoot.right);
	      
	      int lineCount = Math.max(leftLines.length, rightLines.length);
	      String[] allLines = new String[lineCount + 2];

	      if (subtreeRoot.left == null) {
	         allLines[0] = rootString;
	         allLines[1] = getSpaces(rootStrLen) + "\\";

	         int rightChildIndent = rightLines[0].indexOf('[');
	         if (rightChildIndent <= rootStrLen) {
	            indentLines(rightLines, rootStrLen - rightChildIndent);
	         }
	         else {
	            String indent = getSpaces(rightChildIndent - rootStrLen);
	            allLines[0] = indent + allLines[0];
	            allLines[1] = indent + allLines[1];
	         }

	         System.arraycopy(rightLines, 0, allLines, 2, rightLines.length);
	         
	         return allLines;
	      }
	      
	      if (subtreeRoot.right == null) {

	         String indent = getSpaces(leftLines[0].indexOf(']'));
	         allLines[0] = indent + " " + rootString;
	         allLines[1] = indent + "/";
	         System.arraycopy(leftLines, 0, allLines, 2, leftLines.length);
	         
	         return allLines;
	      }
	      
	      int indentNeeded = 0;
	      if (rightLines.length > 0) {
	         indentNeeded = Math.max(0, 
	            leftLines[0].length() + rootString.length() - rightLines[0].indexOf('['));
	      }
	      for (int i = 0; i < leftLines.length && i < rightLines.length; i += 2) {
	         int leftEnd = leftLines[i].lastIndexOf(']');
	         int rightBegin = rightLines[i].indexOf('[');
	         
	         int forThisLine = leftLines[i].length() + 3 - rightBegin;
	         indentNeeded = Math.max(indentNeeded, forThisLine);
	      }
	      String absoluteIndent = getSpaces(indentNeeded);
	      for (int i = 0; i < leftLines.length || i < rightLines.length; i++) {
	         if (i >= rightLines.length) {
	            allLines[2 + i] = leftLines[i];
	         }
	         else {
	            String left = "";
	            if (i < leftLines.length) {
	               left = leftLines[i];
	            }
	            String right = absoluteIndent + rightLines[i];
	            allLines[2 + i] = left + right.substring(left.length());
	         }
	      }
	      int leftIndex = allLines[2].indexOf(']');
	      int rightIndex = allLines[2].lastIndexOf('[');
	      allLines[1] = getSpaces(leftIndex) + "/" + 
	         getSpaces(rightIndex - leftIndex - 1) + "\\";
	      
	      rootStrLen = rightIndex - leftIndex - 1;
	      if (rootString.length() < rootStrLen) {
	         int difference = rootStrLen - rootString.length();
	         String underscores = getRepeated('_', difference / 2);
	         if (difference % 2 == 0) {
	            rootString = underscores + rootString + underscores;
	         }
	         else {
	            rootString = underscores + rootString + underscores + "_";
	         }
	      }
	      allLines[0] = getSpaces(leftIndex + 1) + rootString;
	      
	      return allLines;
	   }
	   
	   private static String getRepeated(char toRepeat, int numberOfTimes) {
	      if (numberOfTimes <= 0) {
	         return "";
	      }

	      char[] chars = new char[numberOfTimes];
	      for (int i = 0; i < numberOfTimes; i++) {
	         chars[i] = toRepeat;
	      }
	      return new String(chars);
	   }
	   
	   private static String getSpaces(int numberOfSpaces) {
	      return getRepeated(' ', numberOfSpaces);
	   }
	   
	   private static void indentLines(String[] lines, int numberOfSpaces) {
	      if (numberOfSpaces <= 0) {
	         return;
	      }

	      String indent = getSpaces(numberOfSpaces);
	      for (int i = 0; i < lines.length; i++) {
	         lines[i] = indent + lines[i];
	      }
	   }
}
