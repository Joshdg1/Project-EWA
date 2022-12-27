<template>
  <div><div class="container">
    <div class="body d-md-flex align-items-center justify-content-between">
      <div class="box-1 mt-md-0 mt-5">
        <img src="https://picsum.photos/600/800"
             class="" alt="">
      </div>
      <div class=" box-2 d-flex flex-column h-100">
        <div class="mt-5">
          <p class="mb-1 h-1">Registreer</p>
          <p class="text-muted mb-2">Registreer een nieuwe programmeur.</p>
          <div class="d-flex flex-column ">
            <p class="text-muted mb-2">Registreer met...</p>
            <div class="d-flex align-items-center">
              <form>
                <!-- Email input -->
                <div class="form-outline mb-4">
                  <label class="form-label" for="form2Example1">Email-adres</label>
                  <input type="email" id="form2Example1" class="form-control" />
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                  <label class="form-label" for="form2Example2">Volledige naam</label>
                  <input type="password" id="form2Example2" class="form-control" />
                </div>

                <!-- Submit button -->
                <button type="button" class="btn btn-primary btn-block mb-4">Registreer</button>
              </form>
            </div>
          </div>
        </div>
        <div class="mt-auto">
          <p class="footer text-muted mb-0 mt-md-0 mt-4">Door te registreren gaat u akkoord met onze
            <span class="p-color me-1">voorwaarden</span>en onze
            <span class="p-color ms-1">privacybeleid</span>
          </p>
        </div>
      </div>
    </div>
  </div></div>
</template>

<script>
export default {
  // eslint-disable-next-line
  name: "Register"
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif
}

form {
  margin-top: 6%;
}

.container {
  margin: 50px auto;
}

.body {
  position: relative;
  width: 720px;
  height: 440px;
  margin: 20px auto;
  border: 1px solid #dddd;
  border-radius: 18px;
  overflow: hidden;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.box-1 img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.box-2 {
  padding: 10px;
}

.box-1,
.box-2 {
  width: 50%;
}

.h-1 {
  font-size: 24px;
  font-weight: 700;
}

.text-muted {
  font-size: 14px;
}

.container .box {
  width: 100px;
  height: 100px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 2px solid transparent;
  text-decoration: none;
  color: #615f5fdd;
}

.box:active,
.box:visited {
  border: 2px solid #ee82ee;
}

.box:hover {
  border: 2px solid #ee82ee;
}

.btn.btn-primary {
  background-color: transparent;
  color: #ee82ee;
  border: 0px;
  padding: 0;
  font-size: 14px;
}

.btn.btn-primary .fas.fa-chevron-right {
  font-size: 12px;
}

.footer .p-color {
  color: #ee82ee;
}

.footer.text-muted {
  font-size: 10px;
}

.fas.fa-times {
  position: absolute;
  top: 20px;
  right: 20px;
  height: 20px;
  width: 20px;
  background-color: #f3cff379;
  font-size: 18px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.fas.fa-times:hover {
  color: #ff0000;
}

@media (max-width:767px) {
  body {
    padding: 10px;
  }

  .body {
    width: 100%;
    height: 100%;
  }

  .box-1 {
    width: 100%;
  }

  .box-2 {
    width: 100%;
    height: 440px;
  }
}
</style>
