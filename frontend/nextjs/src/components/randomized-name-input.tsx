"use client";
import { Label } from "@/components/ui/label";
import { Input } from "@/components/ui/input";
import { Button } from "./ui/button";
import { useState } from "react";

function getRandomElement(arr: string[]) {
  const randomIndex = Math.floor(Math.random() * arr.length);
  return arr[randomIndex];
}
interface RandomizedNameInputProps {
  onNameChange: (newName: string) => void;
}
export default function RandomizedNameInput({
  onNameChange,
}: RandomizedNameInputProps) {
  const fruits = [
    "Apple",
    "Banana",
    "Cherry",
    "Date",
    "Elderberry",
    "Fig",
    "Grape",
    "Honeydew",
    "Jackfruit",
    "Kiwi",
    "Lemon",
    "Mango",
    "Nectarine",
    "Orange",
    "Papaya",
    "Quince",
    "Raspberry",
    "Strawberry",
    "Tomato",
    "Watermelon",
    "Xigua",
    "Zucchini",
  ];
  const fantasyTerms = [
    "Squire",
    "Knight",
    "Wizard",
    "Alchemist",
    "Bard",
    "Druid",
    "Enchanter",
    "Falconer",
    "Guardian",
    "Healer",
    "Illusionist",
    "Jester",
    "King",
    "Lorekeeper",
    "Mystic",
    "Noble",
    "Oracle",
    "Paladin",
    "Queen",
    "Ranger",
    "Sage",
    "Templar",
    "Unicorn",
    "Valkyrie",
    "Warlock",
    "Xylophonist",
    "Ysgramor",
    "Zealot",
  ];

  // State to hold the current name
  const [name, setName] = useState(
    ` ${getRandomElement(fruits)} The ${getRandomElement(fantasyTerms)}`
  );

  // Handler to update the name with a new random value
  const handleRandomize = () => {
    const newName = `${getRandomElement(fruits)} The ${getRandomElement(
      fantasyTerms
    )}`;
    setName(newName);
    onNameChange(newName);
  };
  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setName(event.target.value);
    onNameChange(event.target.value);
  };
  return (
    <div className="space-y-2">
      <Label htmlFor="name">Name</Label>
      <div className="flex space-x-2">
        <Input
          id="name"
          placeholder="Enter your name"
          value={name} // Reflects the state value
          onChange={handleChange} // Updates the state when manually edited
        />
        <Button onClick={handleRandomize} className="ml-2">
          Randomize
        </Button>
      </div>
    </div>
  );
}
