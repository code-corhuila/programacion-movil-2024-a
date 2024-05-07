<template>
  <ion-input v-bind="$attrs" :type="type" :id="id" :value="value" :placeholder="placeholder" :clearInput="clearInput" :debounce="debounce" :disabled="disabled" :maxlength="maxlength" :min="min" :max="max" :step="step"></ion-input>
</template>

<script lang="ts">
import { IonInput } from '@ionic/vue';
import { defineComponent } from 'vue';

export default defineComponent({
  components: { IonInput },
  props: {
    id: String,
    type: String,
    name: String,
    value: String,
    placeholder: String, 
    clearInput: Boolean,
    debounce: Number,
    disabled: Boolean,
    maxlength: Number,
    min: Number,
    max: Number,
    step: Number,
  }
});
</script>

<style scoped>
/* Estilos del componente */
/* Estilos globales */
</style>
