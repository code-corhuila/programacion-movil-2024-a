<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Carrito de compra</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Login</ion-title>
        </ion-toolbar>
      </ion-header>
      <div id="login-container">
        <img src="../asset/img/login.jpg" alt="Imagen de carrito de compra" id="cart-image" />
      
        <div id="description">
          <p>Bienvenido al carrito de compra. Por favor, inicia sesión para continuar.</p>
        </div>
      
        <div id="login-form">
          <InputComponent id="user" name="user" label="Usuario: " />
          <InputComponent type="password" id="password" name="password" label="Contraseña: " />
          <ButtonComponent id="login" value="Login" fill="outline" />
        </div>

        <div>
          <ButtonComponent id="save" value="Guardar" fill="outline" color="success"/>

          <ButtonComponent id="update" value="Modificar" fill="outline" color="warning"/>

          <ButtonComponent id="detele" value="Eliminar" expand="block" color="danger"/>
        </div>
        <div>
          <InputComponent type="password" id="personaId"  />

          <InputComponent type="date" id="fecha"  />
        </div>

        <!-- <div>
          <ion-button fill="outline">Default</ion-button>
          <ion-button :disabled="true" fill="outline">Disabled</ion-button>
        </div> -->
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import InputComponent from '@/components/InputComponent.vue';
</script>

<style scoped>
#login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
}

#cart-image {
  margin-bottom: 20px;
  width: 100px;
}

#description {
  margin-bottom: 20px;
  text-align: center;
}

#description p {
  margin: 0;
  padding: 10px; 
}

#login-form {
  max-width: 300px;
  width: 100%;
}
</style>
