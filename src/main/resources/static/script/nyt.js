window.addEventListener('load', (event) => {

const app = document.getElementById('root')


const container = document.createElement('div')
container.setAttribute('class', 'container')


app.appendChild(container)

let request = new XMLHttpRequest()
request.open('GET', 'https://api.nytimes.com/svc/topstories/v2/food.json?api-key=0KaBAGFOKItJ0ztrTYDlJ0751NHxkwTD', true)
request.onload = function() {
  // Begin accessing JSON data here
  let data = JSON.parse(this.response)
  if (request.status >= 200 && request.status < 400) {
    data.results.forEach(article => {
      let card = document.createElement('div')
      card.setAttribute('class', 'card')

      let h1 = document.createElement('h1')
      h1.textContent = article.title
      h1.setAttribute("class", "nytTitle")

      let p = document.createElement('p')
      article.byline = article.byline.substring(0, 300)
      p.textContent = `${article.byline}...`
      let img = new Image();
      img.src = article.multimedia[0].url;
      img.setAttribute("class", "banner-img");
      img.setAttribute("alt", "effy");
      document.getElementById("img-container").appendChild(img);

      let p2 = document.createElement('p')
      p2.textContent = `${article.abstract}...`

      let a1 = document.createElement('a')
      a1.href = article.url;
      a1.text = 'Link to article';
      a1.setAttribute("target", "blank");



      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(p)
      card.appendChild(img)
      card.appendChild(p2)
      card.appendChild(a1)
    })
  } else {
    let errorMessage = document.createElement('p')
    errorMessage.textContent = `Error loading article`
    app.appendChild(errorMessage)
  }
}

request.send()

});
