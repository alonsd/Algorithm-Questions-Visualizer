package com.alqoview.ui.screens


/**
 * File for demonstrating Intellij IDE design system with solutions
so we can implement it in the app.
 */


// Leetcode 1
fun twoSum(numbers: IntArray, target: Int): IntArray? {
    val map = hashMapOf<Int, Int>()
    numbers.forEachIndexed { index, value ->
        val complement = target - value
        if (map.containsKey(complement))
            return intArrayOf(map[complement]!!, index)
        map[value] = index
    }
    return null
}

//Leetcode 2
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    val head = ListNode(0)
    var current = head
    var carry = 0
    while (l1 != null || l2 != null || carry != 0) {
        val x = l1?.`val` ?: 0
        val y = l2?.`val` ?: 0
        val sum = carry + x + y
        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!
        if (l1 != null) {
            l1 = l1.next
        }
        if (l2 != null) {
            l2 = l2.next
        }
    }
    return head.next
}