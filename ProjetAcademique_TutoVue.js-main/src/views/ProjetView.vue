<template>
	<!-- <v-container fluid fill-height class="d-flex deep-purple lighten-1">
		<h1>Portfolio</h1>
	</v-container> -->
	<div class="projet">
		<h2>Mes projets</h2>
		<ul>
			<li class="div1 firstEffect">
				<a href="https://github.com/Bee-Driver">
					<p>Bee Driver</p>
				</a>
			</li>
			<li class="div2">
				<a href="https://taxiabdel.fr">
					<p>Taxi Abdel</p>
				</a>
			</li>
			<li class="div3">
				<a href="https://github.com/Jukiyoomi/open-innov">
					<p>BabyQuizz</p>
				</a>


			</li>
			<li class="div4 box">
				<a href="https://meymounboualaoui.fr/">
					<p>Portfolio</p>
				</a>


			</li>
		</ul>
	</div>
</template>

<script>
</script>
      
<style scoped>
ul>li>a {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	justify-items: center;
	align-items: center;
	align-content: center;

	text-decoration: none;
	color: #000;

}

ul>li>a:hover {
	text-decoration: underline;
	font-weight: bold;
}

.box {

	background-color: #F7F7F7;
	position: relative;
	box-shadow: 10px 10px 42px 0 rgba(0, 0, 0, 0.75);

	display: grid;
}

.box:hover {
	cursor: pointer;
}

.box:after,
.box:before {
	mix-blend-mode: multiply;
	filter: none;
	z-index: -1;
	content: '';
	width: calc(100% + (40px * 2));
	height: calc(100% + (40px * 2));
	position: absolute;
	display: block;
	top: 11px;
	left: 10px;
	animation: border 10s ease-in-out infinite;
	transform: translateX(-50px) translateY(-50px);
}

@keyframes border {

	0%,
	100% {
		-webkit-clip-path: polygon(0 0, calc(100% - (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 100%, calc(0% + (33.3333333333px)) calc(100% - (33.3333333333px)));
		clip-path: polygon(0 0, calc(100% - (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 100%, calc(0% + (33.3333333333px)) calc(100% - (33.3333333333px)));
	}

	50% {
		-webkit-clip-path: polygon(calc(0% + (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 0, calc(100% - (33.3333333333px)) calc(100% - (33.3333333333px)), 0 100%);
		clip-path: polygon(calc(0% + (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 0, calc(100% - (33.3333333333px)) calc(100% - (33.3333333333px)), 0 100%);
	}
}

.box:after {
	animation-delay: -5s;
	background-color: #3FB27F;
	clip-path: polygon(0 0, calc(100% - (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 100%, calc(0% + (33.3333333333px)) calc(100% - (33.3333333333px)));
}

.box:before {
	background-color: #32475B;
	clip-path: polygon(calc(0% + (33.3333333333px)) calc(0% + (33.3333333333px)), 100% 0, calc(100% - (33.3333333333px)) calc(100% - (33.3333333333px)), 0 100%);
}

.box:hover:after {
	animation-delay: 1s;
}

.box:hover:before,
.box:hover:after {

	animation-duration: 1.3s;
}

.projet {
	width: 100%;
	margin: 0 0 40px 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

ul {
	margin: 40px 0 0 0;
	padding: 0%;
	list-style: none;
	width: fit-content;

	display: grid;
	grid-template-columns: repeat(2, 1fr);
	grid-template-rows: repeat(2, 1fr);
	grid-column-gap: 200px;
	grid-row-gap: 80px;

	justify-items: center;
	align-items: center;
	align-content: center;
}

.div1 {
	grid-area: 1 / 1 / 2 / 2;
}

.div2 {
	grid-area: 1 / 2 / 2 / 3;
}

.div3 {
	grid-area: 2 / 1 / 3 / 2;
}

.div4 {
	grid-area: 2 / 2 / 3 / 3;
}

li {
	width: 22vw;
	height: 27vh;

	display: flex;
	text-align: center;
	justify-content: center;
	align-items: center;
}

.firstEffect {
	--angle: 0deg;
	border: 1vmin solid;
	/* border-image: conic-gradient(from var(--angle), red, yellow, lime, aqua, blue, magenta, red) 1; */
	animation: 5s rotate linear infinite;
}

@keyframes rotate {
	to {
		--angle: 360deg;
	}
}

@property --angle {
	syntax: '<angle>';
	initial-value: 0deg;
	inherits: false;
}

li:first-child {
	background: radial-gradient(ellipse farthest-corner at right bottom, #FEDB37 0%, #FDB931 8%, #9f7928 30%, #8A6E2F 40%, transparent 80%), radial-gradient(ellipse farthest-corner at left top, #FFFFFF 0%, #FFFFAC 8%, #D1B464 25%, #5d4a1f 62.5%, #5d4a1f 100%);
	font: "Baskerville", "Garamond", "Georgia", "Palatino", "Times New Roman", "Arial", sans-serif;
	border-image: conic-gradient(from var(--angle), #FEDB37, #FDB931, #9f7928, #8A6E2F, #D1B464, #FFFFAC, #D1B464, #8A6E2F, #9f7928, #FDB931, #FEDB37) 1;
}

li:first-child:hover {
	cursor: pointer;
	animation: 2s rotate linear infinite;
}

li:nth-child(2) {
	--b: 5px;
	/* the border thickness */
	--d: 20px;
	/* the distance from the edge */
	--o: 15px;
	/* the offset on hover */
	--s: 1;
	/* the direction of the hover effect (+1 or -1)*/

	--_d: calc(var(--d) + var(--s)*1em);
	--_g: calc(100% - 2*(var(--_d) + var(--b)));
	--_m:
		conic-gradient(from 90deg at var(--_d) var(--_d), #0000 25%, #000 0) 0 0/calc(100% - var(--_d)) calc(100% - var(--_d)),
		linear-gradient(#000 0 0) 50%/var(--_g) var(--_g) no-repeat;
	-webkit-mask: var(--_m);
	mask: var(--_m);
	font-size: 0;
	cursor: pointer;
	transition: .35s;


	background: linear-gradient(90deg, rgba(0, 0, 0, 1) 0%, rgba(32, 32, 32, 1) 20%, rgba(134, 134, 134, 1) 40%, rgba(186, 186, 186, 1) 70%, rgba(255, 255, 255, 1) 100%);
}

li:nth-child(2):hover {
	cursor: pointer;
	font-size: var(--d);
}

li:nth-child(3) {
	background: linear-gradient(-45deg, #ef32d9, #b13ce7, #89ffac, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;

	border: 1px solid transparent;
}

li:nth-child(3):hover {
	cursor: pointer;
	border: white;
	border-radius: 50px;

	-webkit-transition: border-radius 200ms ease-in-out;
	-moz-transition: border-radius 200ms ease-in-out;
	-o-transition: border-radius 200ms ease-in-out;
	transition: border-radius 200ms ease-in-out;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}

	50% {
		background-position: 100% 50%;
	}

	100% {
		background-position: 0% 50%;
	}
}


li:nth-child(4) {
	display: grid;
	grid-template-columns: 1fr;
	grid-template-rows: 1fr;
	grid-column-gap: 0px;
	grid-row-gap: 0px;

	justify-items: center;
}

li:nth-child(4)>div:nth-child(2) {
	grid-area: 1 / 1 / 2 / 2;
}

li:nth-child(4)>div:nth-child(2)>p {
	margin-top: 0;
}


@media screen and (max-width: 1080px) {
	ul {
		grid-column-gap: 80px;
		grid-row-gap: 40px;
	}

	li {
		width: 30vw;
		height: 25vh;
	}
}

@media screen and (max-width: 700px) {
	ul {
		grid-column-gap: 40px;
		grid-row-gap: 40px;
	}

	li {
		width: 35vw;
		height: 18vh;
	}
}
</style>