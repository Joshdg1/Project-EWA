<template>
  <section class="page_404">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 ">
          <div class="col-sm-10 col-sm-offset-1  text-center">
            <div class="four_zero_four_bg">
              <h1 class="text-center ">404</h1>


            </div>

            <div class="contant_box_404">
              <h3 class="h2">
                Look like you're lost
              </h3>

              <p>the page you are looking for not available!</p>

              <router-link to="/home"><a href="" class="link_404">Go to Home</a></router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "404page"
}
</script>

<style scoped>

.page_404{ padding-left: 12%; padding-top: 5%; padding-bottom: 5%;background:#fff; color: orangered;}

.page_404  img{ width:90%;}

.four_zero_four_bg{
  background-image: url(https://cdn.dribbble.com/users/285475/screenshots/2083086/dribbble_1.gif);
  height: 400px;
  background-position: center;
  color: orangered;
}


.four_zero_four_bg h1{
  font-size:80px;
  color: orangered;
}

.four_zero_four_bg h3{
  font-size:80px;
}

.link_404{
  color: #fff!important;
  border-radius: 25px;
  padding: 10px 20px;
  background: orangered;
  margin: 20px 0;
  display: inline-block;}
.contant_box_404{ margin-top:-50px;}
.contant_box_404 h3 {color: orangered}
</style>
