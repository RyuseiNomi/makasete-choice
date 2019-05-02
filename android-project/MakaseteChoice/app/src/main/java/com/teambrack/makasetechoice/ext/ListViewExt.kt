package com.teambrack.makasetechoice.ext

import android.widget.ListView

/**
 * [ListView]のheightをアイテムの大きさに合わせてくれる拡張関数
 *
 * 参考：https://qiita.com/Tsutou/items/e0e70d6cf81db5b9d13a
 *
 */
fun ListView.setListViewHeightBasedOnChildren() {
    //ListAdapterを取得
    val listAdapter = adapter ?: return
    //初期化
    var totalHeight = 0
    //個々のアイテムの高さを測り、加算していく
    for (i in 0 until listAdapter.count) {
        val listItem = listAdapter.getView(i, null, this)
        listItem.measure(0, 0)
        totalHeight += listItem.measuredHeight
    }
    //LayoutParamsを取得
    val params = layoutParams
    //(区切り線の高さ * 要素数の数)だけ足してあげる
    params.height = totalHeight + (dividerHeight * (listAdapter.count - 1))
    //LayoutParamsにheightをセットしてあげる
    layoutParams = params
}