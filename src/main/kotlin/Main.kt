var k = mutableListOf(
    mutableListOf(' ', ' ', ' '),
    mutableListOf(' ', ' ', ' '),
    mutableListOf(' ', ' ', ' ')
)
var x3InARow = false
var o3InARow = false
var draw = false
var count = 1
fun gamestat () {
    if (k[0][0] == k[0][1] &&k[0][1] == k[0][2] && k[0][0] == 'X' || k[1][0] == k[1][1] && k[1][1] == k[1][2] && k[1][0] == 'X' || k[2][0] == k[2][1] && k[2][1] == k[2][2] && k[2][0]== 'X' ||
        k[0][0] == k[1][0] && k[1][0] == k[2][0] && k[0][0] == 'X' || k[0][1] == k[1][1] && k[1][1] == k[2][1] && k[0][1] == 'X' || k[0][2] == k[1][2] && k[1][2] == k[2][2] && k[0][2] == 'X' ||
        k[0][0] == k[1][1] && k[1][1] == k[2][2] && k[0][0] == 'X' || k[0][2] == k[1][1] && k[1][1] == k[2][0] && k[0][2] == 'X'
    ) {
        x3InARow = true
    }
    if (k[0][0] == k[0][1] && k[0][1] == k[0][2] && k[0][0] == 'O' || k[1][0] == k[1][1] && k[1][1] == k[1][2] && k[1][0] == 'O' || k[2][0] == k[2][1] && k[2][1] == k[2][2] && k[2][0] == 'O' ||
        k[0][0] == k[1][0] && k[1][0] == k[2][0] && k[0][0] == 'O' || k[0][1] == k[1][1] && k[1][1] == k[2][1] && k[0][1] == 'O' || k[0][2] == k[1][2] && k[1][2] == k[2][2] && k[0][2] == 'O' ||
        k[0][0] == k[1][1] && k[1][1] == k[2][2] && k[0][0] == 'O' || k[0][2]== k[1][1] && k[1][1] == k[2][0] && k[0][2] == 'O'
    ) {
        o3InARow = true
    }
    else if (k[0][0] != ' ' && k[0][1] != ' ' && k[0][2] != ' ' && k[1][0] != ' ' && k[1][1] != ' ' && k[1][2] != ' ' &&  k[2][0] != ' ' && k[2][1] != ' ' && k[2][2] != ' ' && !x3InARow && !o3InARow) {
        draw = true
    }
}
fun gameboard () = println("""
---------
| ${k[0][0]} ${k[0][1]} ${k[0][2]} |
| ${k[1][0]} ${k[1][1]} ${k[1][2]} |
| ${k[2][0]} ${k[2][1]} ${k[2][2]} |
--------- 
""")
fun isNumber (s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }
}
fun makemove() {
    while  ( count !=10)  {
        if (x3InARow || o3InARow || draw) break
        println("Enter the coordinates: ")
        val (x, y) = readLine()!!.split(" ")
        if (!isNumber(x) ||!isNumber(y) ) {
            println("You should enter numbers!")
            continue
        }
        if (x.toInt() !in 1..3 || y.toInt() !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            continue
        }
        if (k[x.toInt() - 1][y.toInt() - 1] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        }
        if (count %2 != 0) k[x.toInt() - 1][y.toInt()- 1] = 'X'
        else k[x.toInt() - 1][y.toInt()- 1] = 'O'
        gamestat()
        gameboard()
        count++
    }
}
fun main() {
    gameboard()
    makemove()
    if (x3InARow) println("X wins")
    if (o3InARow) println("O wins")
    if   (draw) println("Draw")
}

