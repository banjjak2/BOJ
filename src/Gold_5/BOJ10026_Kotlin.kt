package Gold_5

import java.io.BufferedReader
import java.io.InputStreamReader

private var weakness = 0
private var nonWeakness = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var map = Array(n) { CharArray(n) }
    var visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        map[it] = br.readLine().toCharArray()
    }

    repeat(n) { row ->
        repeat(n) { column ->
            if (!visited[row][column]) {
                bfs(map, visited, column, row, map[row][column])
                nonWeakness++
            }
        }
    }

    // 적록색약일 때는 초록색이 빨간색으로 보인다고 가정하고 하나로 통일
    // visited도 초기화해주어야 함
    repeat(n) { row ->
        repeat(n) { column ->
            if (map[row][column] == 'G') map[row][column] = 'R'
        }
    }
    visited = Array(n) { BooleanArray(n) }

    repeat(n) { row ->
        repeat(n) { column ->
            if (!visited[row][column]) {
                bfs(map, visited, column, row, map[row][column])
                weakness++
            }
        }
    }

    println("$nonWeakness $weakness")
}

private fun bfs(map: Array<CharArray>, visited: Array<BooleanArray>, x: Int, y: Int, value: Char) {
    if (x < 0 || x >= map[0].size || y < 0 || y >= map.size) return
    if (visited[y][x] || map[y][x] != value) return

    visited[y][x] = true
    bfs(map, visited, x + 1, y, map[y][x])
    bfs(map, visited, x, y + 1, map[y][x])
    bfs(map, visited, x - 1, y, map[y][x])
    bfs(map, visited, x, y - 1, map[y][x])
}
