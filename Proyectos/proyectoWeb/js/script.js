const punctuationElements = document.getElementsByClassName("punctuation");

const GREEN = "#5CB85C";
const YELLOW = "#F0AD4E";
const RED = "#D9534F";

for (var i = 0; i < punctuationElements.length; i++) {
    const punctuation = parseInt(punctuationElements[i].textContent, 10);

    if (punctuation >= 70) {
        punctuationElements[i].style.backgroundColor = GREEN;
    } else if (punctuation >= 50) {
        punctuationElements[i].style.backgroundColor = YELLOW;
    } else if (punctuation >= 0) {
        punctuationElements[i].style.backgroundColor = RED;
    }

}