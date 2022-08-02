package Gold_5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val M = st.nextToken().toInt()
    val N = st.nextToken().toInt()
    val H = st.nextToken().toInt()

    var ripeTomatoes = 0
    var rawTomatoes = 0
    var noTomatoes = 0

    // 높이, 가로, 세로
    val tomatoes = Array(H) { Array(N) { IntArray(M) } }
    val dist = Array(H) { Array(N) { IntArray(M) } }
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    repeat(H) { h ->
        repeat(N) { n ->
            st = StringTokenizer(br.readLine())
            repeat(M) { m ->
                val value = st.nextToken().toInt()
                when (value) {
                    0 -> {
                        dist[h][n][m] = -1
                        rawTomatoes++
                    }
                    1 -> {
                        q.add(Triple(h, n, m))
                        ripeTomatoes++
                    }
                    -1 -> {
                        noTomatoes++
                    }
                }
                tomatoes[h][n][m] = value
            }
        }
    }

    if (noTomatoes + ripeTomatoes == H * M * N) {
        println(0)
        return
    }

    val dirX = intArrayOf(1, 0, -1, 0, 0, 0)
    val dirY = intArrayOf(0, -1, 0, 1, 0, 0)
    val dirZ = intArrayOf(0, 0, 0, 0, 1, -1)
    var answer = 0
    while (q.isNotEmpty()) {
        val (curZ, curY, curX) = q.poll()

        for (i in 0 until 6) {
            val dx = curX + dirX[i]
            val dy = curY + dirY[i]
            val dz = curZ + dirZ[i]

            if (dx < 0 || dx >= M || dy < 0 || dy >= N || dz < 0 || dz >= H) continue
            if (tomatoes[dz][dy][dx] == -1) continue
            if (dist[dz][dy][dx] >= 0) continue
            dist[dz][dy][dx] = dist[curZ][curY][curX] + 1
            answer = max(answer, dist[dz][dy][dx])
            rawTomatoes--
            q.add(Triple(dz, dy, dx))
        }
    }

    if (rawTomatoes != 0) {
        println("-1")
        return
    } else {
        println(answer)
    }
}