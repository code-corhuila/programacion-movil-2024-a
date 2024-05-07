<template>
  <ion-button v-bind="$attrs" :id="id" :expand="expand" :color="color" :size="size" :fill="fill" :shape="shape" :disabled="disabled" :type="type" :href="href" @click="handleClick">{{ value }}</ion-button>
</template>

<script setup lang="ts">
import { IonButton } from '@ionic/vue';
import { defineProps, defineEmits } from 'vue';

// Definir las props que se utilizarán
const props = defineProps(['id', 'value', 'name', 'expand', 'color', 'size', 'fill', 'shape', 'disabled', 'type', 'href', 'nameMethod']);

// Definir los eventos emitidos
const emit = defineEmits(['click']);

// Manejar el click del botón
const handleClick = () => {
  if (props.nameMethod) {
    // Emitir el evento click con el nombre del método
    emit('click', props.nameMethod);
  }
};
</script>

<style scoped>
  /* Estilo global */
</style>
