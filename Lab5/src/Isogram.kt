object Isogram {
    fun isIsogram(input :String) :Boolean {
        return input.toLowerCase()
                .replace("[^A-Za-z]".toRegex(),"") // Remove characters that aren't letters
                .toList().size == input.toLowerCase() // Abuse the fact that toList retains duplicates while toSet doesn't.
                .replace("[^A-Za-z]".toRegex(),"")
                .toSet().size
    }
}