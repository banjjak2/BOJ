package Gold_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * 불, 상근 두 개의 큐 및 이동 횟수로 풀이
 * 불과 상근이가 특정 위치에 있을 때 불의 이동 횟수가 적은 경우 갈 수 없음
 * 이동 횟수가 불이 더 클 경우 상근이는 이동할 수 있음
 */

private val br = BufferedReader(InputStreamReader(System.`in`))
fun main() {
    val testCaseCount = br.readLine().toInt()
    val directX = intArrayOf(0, 0, -1, 1)
    val directY = intArrayOf(1, -1, 0, 0)

    repeat(testCaseCount) testCase@{
        val st = StringTokenizer(br.readLine())
        val column = st.nextToken().toInt()
        val row = st.nextToken().toInt()
        val sangguenQueue: Queue<Pair<Int, Int>> = LinkedList()
        val fireQueue: Queue<Pair<Int, Int>> = LinkedList()
        val map = Array(row) { CharArray(column) }
        val sangguenDist = Array(row) { IntArray(column) }
        val fireDist = Array(row) { IntArray(column) }

        repeat(row) { rowIndex ->
            val line = br.readLine()
            repeat(column) { columnIndex ->
                val char = line[columnIndex]
                map[rowIndex][columnIndex] = char
                if (char == '@') {
                    sangguenQueue.add(Pair(rowIndex, columnIndex))
                    sangguenDist[rowIndex][columnIndex] = 1
                }
                else if (char == '*') {
                    fireQueue.add(Pair(rowIndex, columnIndex))
                    fireDist[rowIndex][columnIndex] = 1
                }
            }
        }

        while (fireQueue.isNotEmpty()) {
            val (fireCurY, fireCurX) = fireQueue.poll()
            for (i in 0 until 4) {
                val dx = fireCurX + directX[i]
                val dy = fireCurY + directY[i]
                if (dx < 0 || dx >= column || dy < 0 || dy >= row) continue
                if (fireDist[dy][dx] != 0) continue
                if (map[dy][dx] == '#' || map[dy][dx] == '*' || map[dy][dx] == '@') continue

                fireDist[dy][dx] = fireDist[fireCurY][fireCurX] + 1
                fireQueue.add(Pair(dy, dx))
            }
        }

        while (sangguenQueue.isNotEmpty()) {
            val (sangguenCurY, sangguenCurX) = sangguenQueue.poll()
            for (i in 0 until 4) {
                val dx = sangguenCurX + directX[i]
                val dy = sangguenCurY + directY[i]
                if (dx < 0 || dx >= column || dy < 0 || dy >= row) {
                    println(sangguenDist[sangguenCurY][sangguenCurX])
                    return@testCase
                }
                if (map[dy][dx] == '#' || map[dy][dx] == '*' || sangguenDist[dy][dx] != 0) continue
                if (fireDist[dy][dx] != 0 && fireDist[dy][dx] <= sangguenDist[sangguenCurY][sangguenCurX] + 1) continue

                sangguenDist[dy][dx] = sangguenDist[sangguenCurY][sangguenCurX] + 1
                sangguenQueue.add(Pair(dy, dx))
            }
        }
        println("IMPOSSIBLE")
    }
}