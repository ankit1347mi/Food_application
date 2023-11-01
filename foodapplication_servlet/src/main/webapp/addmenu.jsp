<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Home</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <div class="container">
      <div class="center">
          <h1>Add Menu</h1>
          <form method="POST" action="addmenu">
              <div class="txt_field">
                  <input type="text" name="name" required>
                  <span></span>
                  <label>Product name</label>
              </div>
              <div class="txt_field">
                  <input type="text" name="type" required>
                  <span></span>
                  <label>Type</label>
              </div>
              <div class="txt_field">
                  <input type="text" name="about" >
                  <span></span>
                  <label>About</label>
              </div>
              <div class="txt_field">
                  <input type="text" name="avail" required>
                  <span></span>
                  <label>Availability</label>
              </div>
              <div class="txt_field">
                  <input type="tel" name="price" required>
                  <span></span>
                  <label>Price</label>
              </div>
              <input name="submit" type="Submit" value="Add Menu">
              <div class="signup_link">
                  
              </div>
          </form>
      </div>
  </div>
  </body>
</html>