<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Carrito de compra</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
        <div id="login-container">  
          <div id="login-form">
            <InputComponent id="id" name="id" type="hidden"/>
            <InputComponent id="tipoDocumento" name="tipoDocumento" label="Tipo Documento: " />
            <InputComponent type="number" id="Documento" name="Documento" label="Documento: " />
            <InputComponent id="nombre" name="nombre" label="Nombre: " />
            <InputComponent id="direccion" name="direccion" label="Dirección: " />
            <InputComponent id="metodoPago" name="metodoPago" label="Método Pago: " />            
          </div>
  
          <div> 
             <!--Traer el componente de los botones de la crud  -->
            <CrudButtonComponent />
          </div>          
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import InputComponent from '@/components/InputComponent.vue';
  import CrudButtonComponent from '@/components/CrudButtonComponent.vue';
  </script>
  
  <style scoped src="../theme/container.css"></style>

