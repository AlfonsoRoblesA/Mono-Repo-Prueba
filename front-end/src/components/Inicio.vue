<template>
  <v-form ref="form" v-model="valid" lazy-validation>
    <v-card class="mx-auto my-12" max-width="400">
      <v-container>
        <div class="text-center">
          <v-row justify="center">
            <v-col cols="12">
              <v-text-field
                v-model="email"
                :rules="emailRules"
                label="E-mail"
                required
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field
                v-model="password"
                :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="passwordRules"
                :type="show ? 'text' : 'password'"
                label="Password"
                counter
                @click:append="show = !show"
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-btn :disabled="!valid" color="blue" class="white--text" @click="validate" block>
                Iniciar
              </v-btn>
            </v-col>
            <v-col cols="6">
              <label> No tienes cuenta? </label>
            </v-col>
            <v-col cols="6">
              <router-link to="/registro">Registrarme</router-link>
            </v-col>
          </v-row>
        </div>
      </v-container>
    </v-card>
  </v-form>
</template>

<script>
export default {
  name: "Inicio",
  data: () => ({
    valid: true,
    password: "",
    show: false,
    passwordRules: [(v) => !!v || "Name is required"],
    email: "",
    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
  }),

  methods: {
    validate() {
      this.$refs.form.validate();
    },
  },
};
</script>
