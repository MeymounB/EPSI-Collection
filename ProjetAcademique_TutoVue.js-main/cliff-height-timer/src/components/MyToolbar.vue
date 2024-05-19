<template>
	<div>
		<v-app-bar dark color="deep-purple" clipped-left app>
			<v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
			<v-toolbar-title @click="goHome" class="white--text">Cliff height timer</v-toolbar-title>
		</v-app-bar>
	</div>
	<div>
		<v-navigation-drawer v-model="drawer" clipped fixed app>
			<myContentDrawer />
		</v-navigation-drawer>
	</div>
</template>

<script>
import myContentDrawer from "@/components/Drawer"
export default {
	name: 'myToolbar',
	components: { myContentDrawer },
	data: function () {
		return {
			drawer: false
		}
	},
	methods: {
		goHome() {
			this.$router.replace('/')
		}
	}
}
</script>