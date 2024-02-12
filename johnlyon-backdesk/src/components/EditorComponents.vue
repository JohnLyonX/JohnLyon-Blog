<template>
  <div style="border: 1px solid #ccc">
    <Toolbar
        style="border-bottom: 1px solid #ccc"
        :editor="editorRef"
        :defaultConfig="toolbarConfig"
        :mode="mode"
    />
    <Editor
        style="height: 500px; overflow-y: hidden;"
        v-model="valueHtml"
        :defaultConfig="editorConfig"
        :mode="mode"
        @onCreated="handleCreated"
    />
  </div>
</template>
<script>
import '@wangeditor/editor/dist/css/style.css' // 引入 css

import {nextTick, onBeforeUnmount, onMounted, ref, shallowRef} from 'vue'
import {Editor, Toolbar} from '@wangeditor/editor-for-vue'

export default {
  components: {Editor, Toolbar},
  props: ['content'],
  setup(props) {
    const editorRef = shallowRef()

    let valueHtml = ref('<p>请输入内容...</p>')
    const toolbarConfig = {}

    onMounted(() => {
      nextTick(() => {
        if (props.content != null) {
          valueHtml.value = props.content
        }
      });
    })


    // 组件销毁时，也及时销毁编辑器
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return
      editor.destroy()
    })

    const handleCreated = (editor) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }

    return {
      editorRef,
      valueHtml,
      mode: 'default', // 或 'simple'
      toolbarConfig,
      handleCreated
    };
  }
}
</script>
<style scoped>

</style>