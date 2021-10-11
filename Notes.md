# Notes

## Personal Comments
FFXIV is better than WoW :) <br />
The goblin that insta-rages and one-shots because he doesn't believe in shared code ownership should reconsider! I'm sure he would change his mind after sharing a hearty meal. Alas, I will not touch the Item.java class.

## Technical Comments
<ol>
<li>First thing I did after loading down the project was run all the tests and wrote some pinning tests for the current behavior to both affirm what was written in the README.md</li>
<li>Modified the TexttestFixture to help me look at the backstage passes output a bit better.</li>
<li>The giant tree of if is hard to understand and even harder to maintain. Especially, if we want to add more functionality later. Decided to go with Strategy Design Pattern for this.</li> 
<li>After finishing complete refactoring, re-ran all tests to make sure everything still worked like before.</li>
<li>TDD - Red>Green>Refactor - wrote tests for Conjured items, made sure they failed and then wrote the class for ConjuredUpdateStrategy.</li>
<li> In hindsight, each updateQuality method is small enough, they don't really need to be their own class. </li>
<li> Thought about uses parallelStreams on the array loop, but I think that's overcomplicating things. Not really any difference in performance in small amounts. I did switch the for-loop just because there's absolutely no need to keep track of array index in this use case</li>
</ol>
