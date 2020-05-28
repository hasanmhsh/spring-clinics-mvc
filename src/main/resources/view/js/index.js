const siteContent = {
  "nav": {
    "nav-item-1": "Services",
    "nav-item-2": "Product",
    "nav-item-3": "Vision",
    "nav-item-4": "Features",
    "nav-item-5": "About",
    "nav-item-6": "Contact",
    "img-src": "img/logo.png"
  },
  "cta": {
    "h1": "DOM Is Awesome",
    "button": "Get Started",
    "img-src": "img/header-img.png"
  },
  "main-content": {
    "features-h4":"Features",
    "features-content": "Features content elementum magna eros, ac posuere elvit tempus et. Suspendisse vel tempus odio, in interdutm nisi. Suspendisse eu ornare nisl. Nullam convallis augue justo, at imperdiet metus scelerisque quis.",
    "about-h4":"About",
    "about-content": "About content elementum magna eros, ac posuere elvit tempus et. Suspendisse vel tempus odio, in interdutm nisi. Suspendisse eu ornare nisl. Nullam convallis augue justo, at imperdiet metus scelerisque quis.",
    "middle-img-src": "img/mid-page-accent.jpg",
    "services-h4":"Services",
    "services-content": "Services content elementum magna eros, ac posuere elvit tempus et. Suspendisse vel tempus odio, in interdutm nisi. Suspendisse eu ornare nisl. Nullam convallis augue justo, at imperdiet metus scelerisque quis.",
    "product-h4":"Product",
    "product-content": "Product content elementum magna eros, ac posuere elvit tempus et. Suspendisse vel tempus odio, in interdutm nisi. Suspendisse eu ornare nisl. Nullam convallis augue justo, at imperdiet metus scelerisque quis.",
    "vision-h4":"Vision",
    "vision-content": "Vision content elementum magna eros, ac posuere elvit tempus et. Suspendisse vel tempus odio, in interdutm nisi. Suspendisse eu ornare nisl. Nullam convallis augue justo, at imperdiet metus scelerisque quis.",
  },
  "contact": {
    "contact-h4" : "Contact",
    "address" : "123 Way 456 Street Somewhere, USA",
    "phone" : "1 (888) 888-8888",
    "email" : "sales@greatidea.io",
  },
  "footer": {
    "copyright" : "Copyright Great Idea! 2018"
  },
};

// Example: Update the img src for the logo
// let logo = document.getElementById("logo-img");
// logo.setAttribute('src', siteContent["nav"]["img-src"]);



document.querySelectorAll('nav a').forEach((item,idx)=>item.textContent=siteContent.nav["nav-item-"+(idx+1).toString()]);
document.querySelector('#logo-img').src = siteContent.nav['img-src'];
document.querySelector('.cta-text h1').innerHTML='DOM<br> Is<br> Awesome';
document.querySelector('.cta-text button').textContent=siteContent.cta.button;
document.querySelector('#cta-img').src=siteContent.cta["img-src"];
document.querySelectorAll('.main-content .top-content .text-content h4')[0].textContent=siteContent["main-content"]["features-h4"];
document.querySelectorAll('.main-content .top-content .text-content p')[0].textContent=siteContent["main-content"]["features-content"];
document.querySelectorAll('.main-content .top-content .text-content h4')[1].textContent=siteContent["main-content"]["about-h4"];
document.querySelectorAll('.main-content .top-content .text-content p')[1].textContent=siteContent["main-content"]["about-content"];
document.querySelector('.middle-img').src=siteContent["main-content"]["middle-img-src"];
document.querySelectorAll('.main-content .bottom-content .text-content h4')[0].textContent=siteContent["main-content"]["services-h4"];
document.querySelectorAll('.main-content .bottom-content .text-content p')[0].textContent=siteContent["main-content"]["services-content"];
document.querySelectorAll('.main-content .bottom-content .text-content h4')[1].textContent=siteContent["main-content"]["product-h4"];
document.querySelectorAll('.main-content .bottom-content .text-content p')[1].textContent=siteContent["main-content"]["product-content"];
document.querySelectorAll('.main-content .bottom-content .text-content h4')[2].textContent=siteContent["main-content"]["vision-h4"];
document.querySelectorAll('.main-content .bottom-content .text-content p')[2].textContent=siteContent["main-content"]["vision-content"];
document.querySelector('.contact h4').textContent=siteContent.contact["contact-h4"];
document.querySelectorAll('.contact p')[0].textContent=siteContent.contact["address"];
document.querySelectorAll('.contact p')[1].textContent=siteContent.contact["phone"];
document.querySelectorAll('.contact p')[2].textContent=siteContent.contact["email"];
document.querySelector('footer p').textContent=siteContent.footer.copyright;
document.querySelectorAll('a').forEach(item=>item.style.color='green');
const appendedLink = document.createElement('a');
appendedLink.textContent = 'Last';
appendedLink.style.color='green';
appendedLink.href='#';
document.querySelector('header nav').append(appendedLink);
const prependedLink = document.createElement('a');
prependedLink.textContent = 'First';
prependedLink.style.color='green';
prependedLink.href='#';
document.querySelector('header nav').prepend(prependedLink);