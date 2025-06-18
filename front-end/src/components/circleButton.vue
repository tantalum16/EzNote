<template>

<button class="circle-button"
:class="{
      hovered: isHovered,
      active: isActive
    }"
    @mouseenter="isHovered = true"
    @mouseleave="isHovered = false"
    @mousedown="isActive = true"
    @mouseup="isActive = false"
    @click="handleClick"
>
+
</button>
  

</template>


<script setup>
import { ref } from 'vue'
const isHovered = ref(false)
const isActive = ref(false)

function handleClick() {
  console.log('按钮点击，画布已创建')
}

</script>


<style scoped>
.circle-button {
  position: fixed;
  right: 30px;
  bottom: 30px;
  width: 56px;
  height: 56px;
  border-radius: 50%;
  background-color: #2196f3;
  color: #fff;
  font-size: 32px;
  border: none;
  box-shadow: 0 2px 8px rgba(0,0,0,0.2);
  cursor: pointer;
  transition: background 0.2s, box-shadow 0.2s;
}
.circle-button.hovered {
  background-color: #1565c0;
  box-shadow: 0 4px 16px rgba(0,0,0,0.3);
}
.circle-button.active {
  background-color: #2196f3;
  box-shadow: 0 2px 8px rgba(0,0,0,0.2);
}

</style>