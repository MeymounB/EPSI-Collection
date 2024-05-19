<template>
	<div>
		<v-toolbar class="deep-purple" />
		<v-list dense>
			<template v-for="(item, i) in items">
				<v-divider dark v-if="item.divider" :key="i"></v-divider>
				<v-list-item ripple :to="item.action" :key="i" v-else>
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
				{ icon: 'home', text: this.$t('drawer.home'), action: '/home' },
				{ icon: 'projets', text: this.$t('drawer.projets'), action: '/projets' },
				{ icon: 'contact', text: this.$t('drawer.contact'), action: '/contact' },
				{ icon: 'history', text: this.$t('drawer.my_history'), action: '/history' },
				{ icon: 'clock', text: this.$t('drawer.my_clock'), action: '/clock' },

			]
		}
	}
}
</script>