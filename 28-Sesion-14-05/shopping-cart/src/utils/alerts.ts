import Swal from 'sweetalert2';

// Mensajes genéricos
export const SUCCESS_MESSAGE = 'Operación realizada con éxito.';
export const ERROR_MESSAGE = 'Hubo un error al realizar la operación. Por favor, inténtalo de nuevo más tarde.';
export const SUCCESS_TITLE = '¡Éxito!';
export const ERROR_TITLE = '¡Error!';

// Funciones genéricas para mostrar mensajes
export async function showSuccessMessage(message?: string) {
  await Swal.fire({
    icon: 'success',
    title: SUCCESS_TITLE,
    text: message || SUCCESS_MESSAGE,
    showConfirmButton: false,
    timer: 1500
  });
}

export async function showErrorMessage(message?: string) {
  await Swal.fire({
    icon: 'error',
    title: ERROR_TITLE,
    text: message || ERROR_MESSAGE
  });
}

// Funciones específicas para operaciones CRUD
// Actualizar registro
export async function showUpdateSuccessMessage(message?: string) {
  await showSuccessMessage(message || 'Registro actualizado con éxito.');
}

export async function showUpdateErrorMessage(message?: string) {
  await showErrorMessage(message || 'Hubo un error al actualizar el registro.');
}

// Eliminar registro
export async function showDeleteSuccessMessage(message?: string) {
  await showSuccessMessage(message || 'Registro eliminado con éxito.');
}

export async function showDeleteErrorMessage(message?: string) {
  await showErrorMessage(message || 'Hubo un error al eliminar el registro.');
}

// Inhabilitar registro
export async function showDisableSuccessMessage(message?: string) {
  await showSuccessMessage(message || 'Registro inhabilitado con éxito.');
}

export async function showDisableErrorMessage(message?: string) {
  await showErrorMessage(message || 'Hubo un error al inhabilitar el registro.');
}

// Buscar registro por identificación
export async function showSearchSuccessMessage(message?: string) {
  await showSuccessMessage(message || 'Registro encontrado con éxito.');
}

export async function showSearchErrorMessage(message?: string) {
  await showErrorMessage(message || 'No se pudo encontrar el registro.');
}

// Función genérica para listar registros
export async function showListSuccessMessage(message?: string) {
  await showSuccessMessage(message || 'Registros listados con éxito.');
}

export async function showListErrorMessage(message?: string) {
  await showErrorMessage(message || 'Hubo un error al listar los registros.');
}