class IsbnVerifier {
    fun isValid(input :String) :Boolean {
        return input != "" && input.length >= 10 && input
                .replace("-","")
                .toCharArray()
                .mapIndexed{ i, c -> if (input.replace("-","").lastIndex == i && c.toUpperCase() == 'X') 10 else c - '0'}
                .zip((10).downTo(0))
                .asSequence()
                .map { (a, b) -> a * b }
                .sum() % 11 == 0
    }
}