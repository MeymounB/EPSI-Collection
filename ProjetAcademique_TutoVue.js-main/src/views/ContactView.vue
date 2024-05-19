<template>
  <div class="contact">

    <form class="form">
      <div class="pageTitle title">Formulaire</div>
      <div class="secondaryTitle title">En espérant faire connaissance avec vous !</div>
      <input type="text" class="name formEntry" placeholder="Nom" />
      <input type="text" class="email formEntry" placeholder="Email" />
      <textarea class="message formEntry" placeholder="Message"></textarea>
      <div class="policy"><input type="checkbox" class="termsConditions" value="Term">
        <label for="terms"> J'accepte les <span style="color: #0e3721">conditions
            d'utilisations</span> & <span style="color: #0e3721">politiques de confidentialité</span>.</label>
      </div>
      <button class="submit formEntry" onclick="thanks()">Envoyer</button>
    </form>
  </div>
</template>

<style scoped>
/* form animation starts */
.form {
  background: #fff;
  box-shadow: 0 30px 60px 0 rgba(90, 116, 148, 0.4);
  border-radius: 5px;
  max-width: 480px;
  margin-left: auto;
  margin-right: auto;
  padding-top: 5px;
  padding-bottom: 5px;
  margin-top: 10px;
  margin-bottom: 10px;
  border-top: 5px solid #0e3721;
  /*   z-index: 1; */
  animation: bounce 1.5s infinite;
}

::-webkit-input-placeholder {
  font-size: 1.3em;
}

.title {
  display: block;
  font-family: sans-serif;
  margin: 10px auto 5px;
  width: 300px;
}

.pageTitle {
  font-size: 2em;
  font-weight: bold;
}

.secondaryTitle {
  color: grey;
}

.name {
  background-color: #ebebeb;
  color: white;
}

.name:hover {
  border-bottom: 5px solid #0e3721;
  height: 30px;
  width: 380px;
  transition: ease 0.5s;
}

.email {
  background-color: #ebebeb;
  height: 2em;
}

.email:hover {
  border-bottom: 5px solid #0e3721;
  height: 30px;
  width: 380px;
  transition: ease 0.5s;
}

.message {
  background-color: #ebebeb;
  overflow: hidden;
  height: 10rem;
}

.message:hover {
  border-bottom: 5px solid #0e3721;
  height: 12em;
  width: 380px;
  transition: ease 0.5s;
}

.policy {
  margin: 0 80px;
  text-align: center;
}

label {
  color: grey;
}

.formEntry {
  display: block;
  margin: 30px auto;
  min-width: 300px;
  padding: 10px;
  border-radius: 2px;
  border: none;
  transition: all 0.5s ease 0s;
}

.submit {
  width: 200px;
  color: white;
  background-color: #0e3721;
  font-size: 20px;
}

.submit:hover {
  box-shadow: 15px 15px 15px 5px rgba(78, 72, 77, 0.219);
  transform: translateY(-3px);
  width: 300px;
  border-top: 5px solid #0e3750;
  border-radius: 0%;
}

@keyframes bounce {
  0% {
    tranform: translate(0, 2px);
  }

  50% {
    transform: translate(0, 4px);
  }
}
</style>