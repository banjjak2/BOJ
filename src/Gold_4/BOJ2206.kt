package Gold_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * 1. 현재 위치에서 상하좌우 확인
 * 2. 상하좌우에서 벽이 있는 경우 이미 한 번 부쉈는지 확인
 *  2-1) 벽을 이미 부순 경우 pass
 *  2-2) 벽을 부수지 않은 경우 벽 부수기
 * 3. 벽을 부수고 이동한 횟수와 부수지 않고 이동한 횟수로 구분
 * 4. 벽을 부수지 않고 이동하다가 중간에 부순 경우 벽을 부수고 이동한 횟수 + 부수지 않고 이동한 횟수를 부수고 이동한 횟수에 추가
 *  => 부수고 이동한 횟수 = 부수지 않고 이동한 횟수 + 1
 * 5. 처음부터 벽을 부순 경우 계속 부수고 이동한 횟수에 추가
 */

fun main() {
    val directX = intArrayOf(0, 0, -1, 1)
    val directY = intArrayOf(-1, 1, 0, 0)
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val row = st.nextToken().toInt()
    val column = st.nextToken().toInt()
    val map = Array(row) { IntArray(column) }
    // IntArray[0] = 벽 부수지 않고 이동한 횟수
    // IntArray[1] = 벽 부수고 이동한 횟수
    val dist = Array(row) { Array(column) { IntArray(2) } }
    repeat(row) { rowIndex ->
        val str = br.readLine()
        repeat(column) { columnIndex ->
            map[rowIndex][columnIndex] = str[columnIndex] - '0'
        }
    }
    // 시작 칸과 끝나는 칸도 포함해서 개수를 세야 하므로
    dist[0][0][0] = 1
    dist[0][0][1] = 1
    q.add(Triple(0, 0, 0))

    while (q.isNotEmpty()) {
        val (curY, curX, isBroken) = q.poll()

        if (curX == column - 1 && curY == row - 1) {
            println(dist[curY][curX][isBroken])
            return
        }

        for (i in 0 until 4) {
            val dx = curX + directX[i]
            val dy = curY + directY[i]
            if (dx < 0 || dx >= column || dy < 0 || dy >= row) continue

            val nextDist = dist[curY][curX][isBroken] + 1
            // 한 번 부수고 이동한 경우 = 한 번이라도 부쉈으면 isBroken 이 1로 설정됨
            // 아직 부수지 않고 이동한 경우
            if (map[dy][dx] == 0 && dist[dy][dx][isBroken] == 0) {
                dist[dy][dx][isBroken] = nextDist
                q.add(Triple(dy, dx, isBroken))
            }
            // 한 번도 안부순 상태에서 벽을 만난 경우
            else if (isBroken != 1 && map[dy][dx] == 1 && dist[dy][dx][1] == 0) {
                dist[dy][dx][1] = nextDist
                q.add(Triple(dy, dx, 1))
            }
        }
    }

    println("-1")
}