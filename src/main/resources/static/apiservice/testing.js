const newsapi = "https://api.sportsdata.io/v3/nba/scores/json/News?key=0f0695cbcd434da582f5688d5897b7fe"

async function news(){
    const response = await fetch(newsapi);
    const data = await response.json();
    return data
}


async function populate(){
    const data = await news()
    console.log(data)
    var content = '<marquee class="news-scroll" behavior="scroll" direction="left" onmouseover="this.stop();" onmouseout="this.start();">';
    for(i = 1; i < 20; i ++){
        content += `<a href="${data[i]['Url']}">${data[i]['Title']} </a> <span class="dot"> </span>` 
    }
    content += '</marquee>'
    document.getElementById("tickerholder").innerHTML = content; 

}


populate()
