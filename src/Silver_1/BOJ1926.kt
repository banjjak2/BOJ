import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val paper = Array(n) { Array(m) { 0 } }
    val visited = Array(n) { Array(m) { false } }

    for (i in 0 until n) {
        val str = StringTokenizer(br.readLine())
        paper[i] = Array(m) { str.nextToken().toInt() }
    }

    // BFS
    val xPos = arrayOf(1, 0, -1, 0)
    val yPos = arrayOf(0, 1, 0, -1)
    val q: Queue<Pair<Int, Int>> = LinkedList()
    var maxAreaOfPicture = 0
    var countOfPicture = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (paper[y][x] == 0 || visited[y][x]) continue
            var countCell = 1
            q.add(Pair(y, x))
            visited[y][x] = true

            while (q.isNotEmpty()) {
                val coordinate = q.poll()
                for (k in 0 until 4) {
                    val dx = coordinate.second + xPos[k]
                    val dy = coordinate.first + yPos[k]

                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue
                    if (visited[dy][dx] || paper[dy][dx] == 0) continue

                    q.add(Pair(dy, dx))
                    visited[dy][dx] = true
                    countCell++
                }
            }
            maxAreaOfPicture = maxAreaOfPicture.coerceAtLeast(countCell)
            countOfPicture++
        }
    }

    println("$countOfPicture\n$maxAreaOfPicture")
}
