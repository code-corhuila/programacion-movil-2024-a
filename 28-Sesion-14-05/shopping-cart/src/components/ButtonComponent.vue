<template>
  <ion-button v-bind="$attrs" :id="id" :expand="expand" :color="color" :size="size" :fill="fill" :shape="shape" :disabled="disabled" :type="type" :href="href" @click="handleClick">
    <ion-icon :icon="getIcon(iconName)"></ion-icon>
  </ion-button>
</template>

<script setup lang="ts">
import { IonButton } from '@ionic/vue';
import { defineProps, defineEmits } from 'vue';
import * as IonIcons from 'ionicons/icons';

// Definir las props que se utilizarán
const props = defineProps(['id', 'value', 'name', 'expand', 'color', 'size', 'fill', 'shape', 'disabled', 'type', 'href', 'nameMethod','iconName']);

// Definir los eventos emitidos
const emit = defineEmits(['click']);

// Manejar el click del botón
const handleClick = () => {
  if (props.nameMethod) {
    // Emitir el evento click con el nombre del método
    emit('click', props.nameMethod);
  }
};

// Obtener el icono correspondiente
// Definir un tipo para los iconos de IonIcons
type IonIconName = keyof typeof IonIcons;

// Obtener el icono correspondiente
const getIcon = (iconName: IonIconName) => {
  return IonIcons[iconName] || '';
};

</script>

<style scoped>
  /* Estilo global */
</style>
