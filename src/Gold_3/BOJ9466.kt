package Gold_3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val GROUP = -1
private const val NOT_VISITED = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCaseCount = br.readLine().toInt()

    repeat(testCaseCount) {
        val n = br.readLine().toInt()
        val students = IntArray(n + 1)
        val state = IntArray(n + 1)
        val st = StringTokenizer(br.readLine())
        var notGroupCount = 0
        for (i in 1..n) {
            students[i] = st.nextToken().toInt()
        }

        for (i in 1..n) {
            if (state[i] == GROUP) continue
            var curStudent = i
            while (true) {
                state[curStudent] = i
                curStudent = students[curStudent]
                if (state[curStudent] == i) {
                    while (state[curStudent] != GROUP) {
                        state[curStudent] = GROUP
                        curStudent = students[curStudent]
                    }
                    break
                } else if (state[curStudent] != NOT_VISITED) break
            }
        }

        for (i in 1..n) {
            if (state[i] != GROUP) notGroupCount++
        }
        println(notGroupCount)
    }
}