<template>
	<v-container>

	</v-container>
</template>
      
<script>
export default {
	name: 'my_history',

}
localStorage.setItem("historique", JSON.stringify([]));
JSON.parse(localStorage.getItem("history"));

</script>