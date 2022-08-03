package Silver_1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()
    val directX = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
    val directY = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)

    repeat(case) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val I = br.readLine().toInt()
        val dist = Array(I) { IntArray(I) }
        var st = StringTokenizer(br.readLine())
        val knightPos = Pair(st.nextToken().toInt(), st.nextToken().toInt())
        st = StringTokenizer(br.readLine())
        val wantPos = Pair(st.nextToken().toInt(), st.nextToken().toInt())

        if (knightPos == wantPos) {
            println("0")
            return@repeat
        }

        q.add(knightPos)
        while (q.isNotEmpty()) {
            val (curX, curY) = q.poll()

            for (i in 0 until 8) {
                val dx = curX + directX[i]
                val dy = curY + directY[i]

                if (dx < 0 || dx >= I || dy < 0 || dy >= I) continue
                if (dist[dy][dx] > 0) continue

                dist[dy][dx] = dist[curY][curX] + 1
                if (dx == wantPos.first && dy == wantPos.second) {
                    println(dist[dy][dx])
                    return@repeat
                }
                q.add(Pair(dx, dy))
            }
        }
    }
}