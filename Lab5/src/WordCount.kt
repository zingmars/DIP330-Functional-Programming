object WordCount {
    fun phrase(phrase: String) :Map<String, Int> {
        return phrase
                .toLowerCase()
                .split("[ \\t\\n\\x0B\\f\\r\\,]".toRegex())  // Split on
                .asSequence()
                .filter { s: String -> s.isNotEmpty() } // Filter out blank lines (in cases if there are multiple delimiter characters following each other)
                .map { s: String -> s.replace("\n|,|:|\\.|!|&|@|\\$|\\%|\\^|\\ |^'|'\$".toRegex(),"") } // Filter out unneeded characters
                .groupingBy { it }
                .eachCount()
    }
}