<template>
	<div>
		// Nouveau
		<v-navigation-drawer v-model="drawer" clipped fixed app>
			<myContentDrawer />
		</v-navigation-drawer>
	</div>
</template>

<script>
import myContentDrawer from "@/components/Drawer" // <== Ajouter l’import

export default {
	name: "myToolbar",
	components: { myContentDrawer }, // <== Ajouter la déclaration du composant
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