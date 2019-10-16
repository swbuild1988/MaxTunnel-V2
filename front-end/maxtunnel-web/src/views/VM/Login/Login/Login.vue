<template>
    <div class="Login-wrap">
        <div class="title">用户登录</div>
        <Form ref="login" :model="loginInfo" :label-width="80">
            <FormItem label="姓名：">
                <Input v-model="loginInfo.username"/>
            </FormItem>
            <FormItem label="密码：">
                <Input v-model="loginInfo.password" />
            </FormItem>
        </Form>
        <div class="btn-wrap">
            <Button type="primary" @click="login">登录</Button>
        </div>
    </div>
</template>

<script lang="ts" src="./Login.ts"></script>

<style lang="less">
    @import './Login.less';
</style>

