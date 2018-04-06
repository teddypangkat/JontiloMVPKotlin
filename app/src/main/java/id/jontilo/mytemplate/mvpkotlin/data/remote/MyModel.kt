package id.jontilo.mytemplate.mvpkotlin.data.remote

/**
 * Created by teddy on 4/6/18.
 */

data class MyModel(
		val menu: Menu
)

data class Menu(
		val id: String,
		val value: String,
		val popup: Popup
)

data class Popup(
		val menuitem: List<Menuitem>
)

data class Menuitem(
		val value: String,
		val onclick: String
)