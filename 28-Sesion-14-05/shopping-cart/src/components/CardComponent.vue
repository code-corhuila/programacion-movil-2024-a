<template>
    <ion-card color="{{color}}">
        <ion-card-header>
            <ion-card-title>{{tituloCard}}</ion-card-title>
            <ion-card-subtitle>{{subtituloCar}}</ion-card-subtitle>
        </ion-card-header>
    </ion-card>
</template>

<script lang="ts">
import { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle,  } from '@ionic/vue';
import { defineComponent } from 'vue';

export default defineComponent({
    components: { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle },
    props: {
        textAlt: String,
        tituloCard: String,
        subtituloCar: String,
        color: String     
    }
});
</script>

<style scoped>
/* Estilos del componente */
/* Estilos globales */
</style>