package ii887522.oxy.functions

import java.io.*

/**
 * It returns the file name with its extension name from the value.
 *
 * @return The file name from the value.
 */
val String.fileName get() = substring(lastIndexOf('/') + 1)

/**
 * It checks whether the directory where its path is given has at least one file with an `extensionName` that is received from the parameter.
 *
 * @param extensionName The extension name used during checking. The name must not start with .
 * @return true if there is at least one file with an `extensionName` that is coming from the parameter, false otherwise.
 */
fun String.hasFileWithExtension(extensionName: String): Boolean {
  val directory = File(this)
  if (!directory.exists()) return false
  for (file in directory.walkBottomUp()) {
    if (file.toString().endsWith(".${extensionName}")) return true
  }
  return false
}

/**
 * It returns the content that is stored in the file where its path is given.
 *
 * @return The file content without newline character(s).
 * @throws java.io.IOException If any error occurred while trying to read the file where its path is given.
 */
fun String.read(): String {
  val result = StringBuilder()
  BufferedReader(FileReader(this)).use {
    while (true) result.append(it.readLine() ?: break)
  }
  return result.toString()
}

/**
 * It stores the `content` received into the file where its path is given.
 *
 * @param content The file content to be stored.
 */
fun String.write(content: String) {
  BufferedWriter(FileWriter(this)).use {
    it.write(content)
  }
}
