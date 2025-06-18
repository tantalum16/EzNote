<template>
  <div>
    <nav-menu class="navbar"></nav-menu>
    <router-view/>
  </div>


</template>


<script setup>

import NavMenu from './common/NavMenu.vue';


</script>


<style>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
}

</style>