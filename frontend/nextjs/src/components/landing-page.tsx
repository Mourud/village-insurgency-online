
'use client';
import { Button } from "@/components/ui/button";

import RandomizedNameInput from "./randomized-name-input";
import { useState } from "react";

export function LandingPage() {
  const [displayName, setDisplayName] = useState('');

  function help() {

      console.log("Google Display Name:");
  }

  return (
    <div className="flex flex-col items-center space-y-4 min-h-screen py-12 md:py-24">
      <div className="space-y-2 text-center">
        <h1 className="text-3xl font-bold tracking-tighter sm:text-4xl md:text-5xl/none">
          Village Insurgency
        </h1>
        <p className="mx-auto max-w-[600px] text-gray-500 dark:text-gray-400">
          Join our community to access exclusive content and connect with other
          members.
        </p>
      </div>
      <div className="w-full max-w-sm space-y-4">
        <RandomizedNameInput onNameChange={setDisplayName} />
        <Button className="w-full" onClick={() => console.log("Join Anonymously")}>
          Join Anonymously
        </Button>
      </div>
      <div><Button onClick={help}>Get User name</Button></div>
      <div className="w-full max-w-sm space-y-4">
        <div className="space-y-2">
          <p className="text-sm text-gray-500 dark:text-gray-400">
            Or sign up using Google
          </p>
        </div>
        <div className="flex space-x-4">
          <Button className="px-0 flex-1" onClick={() => console.log("Join Anonymously")}>
            <span className="sr-only">Sign up with Google</span>
            <ChromeIcon className="w-6 h-6" />
          </Button>
        </div>
      </div>
      <div className="w-full max-w-2xl border-t border-gray-200 dark:border-gray-800" />
      <div className="w-full max-w-3xl grid gap-6 px-4 text-center md:grid-cols-3 md:px-6 lg:gap-0"></div>
    </div>
  );
}

interface ChromeIconProps {
  className?: string;
}

function ChromeIcon(props: ChromeIconProps) {
  return (
    <svg
      {...props}
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      <circle cx="12" cy="12" r="10" />
      <circle cx="12" cy="12" r="4" />
      <line x1="21.17" x2="12" y1="8" y2="8" />
      <line x1="3.95" x2="8.54" y1="6.06" y2="14" />
      <line x1="10.88" x2="15.46" y1="21.94" y2="14" />
    </svg>
  );
}
