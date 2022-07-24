package Silver_2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testcaseCount = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(testcaseCount) {
        var st = StringTokenizer(br.readLine())
        val column = st.nextToken().toInt()
        val row = st.nextToken().toInt()
        val cabbageCount = st.nextToken().toInt()
        val map = Array(row) { IntArray(column) }
        val visited = Array(row) { BooleanArray(column) }
        var bugCount = 0
        repeat(cabbageCount) {
            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            map[y][x] = 1
        }

        repeat(row) { row ->
            repeat(column) { column ->
                if (map[row][column] == 1 && !visited[row][column]) {
                    bfs(map, visited, column, row)
                    bugCount++
                }
            }
        }

        sb.append(bugCount).append('\n')
    }

    println(sb)
}

private fun bfs(map: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(x, y))
    visited[y][x] = true

    val directX = arrayOf(1, 0, -1, 0)
    val directY = arrayOf(0, 1, 0, -1)
    while (q.isNotEmpty()) {
        val data = q.poll()

        for(index in 0 until 4) {
            val calcX = data.first + directX[index]
            val calcY = data.second + directY[index]

            if (calcX < 0 || calcX >= map[0].size || calcY < 0 || calcY >= map.size) continue
            if (map[calcY][calcX] == 0 || visited[calcY][calcX]) continue

            q.add(Pair(calcX, calcY))
            visited[calcY][calcX] = true
        }
    }
}