<template>
	<div>
		<v-toolbar class="deep-purple" />
		<v-list dense>
			<template v-for="(item, i) in items">
				<v-divider dark v-if="item.divider" :key="i"></v-divider>
				<v-list-item ripple :to="item.action" :key="y" v-else>
					<v-list-item-action>
						<v-icon>{{ item.icon }}</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title class="body-2">{{ item.text }}</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
			</template>
		</v-list>
	</div>
</template>

<script>
export default {
	name: 'drawer',
	data: function () {
		return {
			items: [
				{ icon: 'home', text: this.$t('drawer.home'), action: '/' },
				{ icon: 'history', text: this.$t('drawer.history'), action: '/history' },
				{ icon: 'help', text: this.$t('drawer.about'), action: '/about' },
			]
		}
	}
}
</script>