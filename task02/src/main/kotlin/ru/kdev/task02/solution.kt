package ru.kdev.task02

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun main(ignored: Array<String>) {
    /*
     Дерево на вход:
              1
     left 2   |   right 2
      3    4  |  4    3
     5 6  . 8 | 8 .  6 5
      4 .  . .|. .  . 4
     1 .      |      . 1
     Должно быть: true
     */
    val tree = TreeNode(1,
        TreeNode(2,
            TreeNode(
                3,
                TreeNode(5),
                TreeNode(6, TreeNode(4, TreeNode(1)), null)
            ),
            TreeNode(
                4,
                null,
                TreeNode(8)
            )
        ),
        TreeNode(2,
            TreeNode(
                4,
                TreeNode(8),
                null
            ),
            TreeNode(
                3,
                TreeNode(6, null, TreeNode(4, null, TreeNode(1))),
                TreeNode(5)
            )
        )
    )

    println(isLeftRightSymmetric(tree))
}

fun isLeftRightSymmetric(treeNode: TreeNode): Boolean {
    val left = treeNode.left
    val right = treeNode.right

    if(left == null && right != null) return false
    if(left != null && right == null) return false
    if(left == null && right == null) return true

    return areSymmetricEqual(left!!, right!!)
}

fun areSymmetricEqual(treeNode1: TreeNode, treeNode2: TreeNode): Boolean {
    val left1 = treeNode1.left
    val right1 = treeNode1.right

    val left2 = treeNode2.left
    val right2 = treeNode2.right

    return left1 == reverseNode(right2) && left2 == reverseNode(right1)
}

fun reverseNode(treeNode: TreeNode?): TreeNode? {
    if(treeNode == null)
        return null

    val left = treeNode.left
    val right = treeNode.right

    return TreeNode(treeNode.value, reverseNode(right), reverseNode(left))
}